package in.v8.services;

import java.lang.foreign.Linker.Option;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.v8.entities.Chat;
import in.v8.entities.User;
import in.v8.exceptions.ChatException;
import in.v8.exceptions.UserException;
import in.v8.repositores.ChatRepository;
import in.v8.request.GroupChatRequest;

@Service
public class ChatServiceImplementation implements ChatService{
	private ChatRepository chatRepository;
	private UserService userService;
	
	public ChatServiceImplementation(ChatRepository chatRepository, UserService userService) {
		this.chatRepository = chatRepository;
		this.userService = userService;
	}

	@Override
	public Chat createChat(User reqUser, Integer UserId2) throws UserException {
		User user = userService.findUserById(UserId2); 
		
		Chat existChat = chatRepository.findSingleChatByUserIds(user, reqUser);
		
		if(existChat != null) {
			return existChat;
		}
		
		Chat createdChat = new Chat();
		createdChat.setCreatedBy(reqUser);
		createdChat.getUsers().add(user);
		createdChat.getUsers().add(reqUser);
		createdChat.setGroup(false);
		
		return createdChat;
	}

	@Override
	public Chat findChatByID(Integer chatId) throws ChatException {
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		if (chatOptional.isPresent()) {
			return chatOptional.get();
		} else {
			throw new ChatException("Chat not found with id " + chatId);
		}
	}

	@Override
	public List<Chat> findAllChatByUserId(Integer userId) throws UserException {
		User user = userService.findUserById(userId);
		if(user.getId() == null) {
			throw new UserException("User Not Exist With Provide id " + userId);
		}
		
		List<Chat> listOfChats = chatRepository.findChatByUserId(user.getId());
		return listOfChats;
	}

	@Override
	public Chat createGroup(GroupChatRequest reqGroup, User reqUser) throws UserException {
		Chat group = new Chat();
		group.setGroup(true);
		group.setChatImage(reqGroup.getChatImage());
		group.setChatName(reqGroup.getChatName());
		group.setCreatedBy(reqUser);
		group.getAdmins().add(reqUser);
		
		for(Integer userId:reqGroup.getUserIds()) {
			User user = userService.findUserById(userId);
			group.getUsers().add(user);
		}
		
		return group;
	}

	@Override
	public Chat addUserToGroup(Integer userId, Integer chatId, User reqUser) throws UserException, ChatException {
		User user = userService.findUserById(userId);
		
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		
		if(chatOptional.isPresent()) {
			Chat chat = chatOptional.get();
			if(chat.getAdmins().contains(reqUser)) {
				chat.getUsers().add(user);
				return chatRepository.save(chat);
			} else {
				throw new UserException("You are not admin. only admin can add group members");
			}
		} else {
			throw new ChatException("Chat not found with id " + chatId);
		}
	}

	@Override
	public Chat renameGroup(Integer chatId, String newName, User reqUser) throws UserException, ChatException {
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		if(chatOptional.isPresent()) {
			Chat chat = chatOptional.get();
			if (chat.getUsers().contains(reqUser)) {
				chat.setChatName(newName);
				return chatRepository.save(chat);
			}else {
				throw new UserException("You are not menber. only members can rename chat or group");
			}
		} else {
			throw new ChatException("Chat not found with id " + chatId);
		}
	}

	@Override
	public Chat removeFromGroup(Integer chatId, Integer userId, User reqUser) throws UserException, ChatException {
		User user = userService.findUserById(userId);
		
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		
		if(chatOptional.isPresent()) {
			Chat chat = chatOptional.get();
			if(chat.getAdmins().contains(reqUser)) {
				chat.getUsers().remove(user);
				return chatRepository.save(chat);
			} else if(chat.getUsers().contains(reqUser)) {
				if(user.getId().equals(reqUser.getId())) {
					chat.getUsers().remove(user);
					return chatRepository.save(chat);
				}
			}
			throw new UserException("You can't remove another user");
		} else {
			throw new ChatException("Chat not found with id " + chatId);
		}
	}

	@Override
	public void deleteChat(Integer chatId, Integer userId) throws UserException, ChatException {
		Optional<Chat> chatOptional = chatRepository.findById(chatId);
		if(chatOptional.isPresent()) {
			Chat chat = chatOptional.get();
			chatRepository.deleteById(userId);
		} else {
			throw new ChatException("Chat not found with id " + chatId);
		}
	}
}
