package in.v8.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.v8.entities.Chat;
import in.v8.entities.Message;
import in.v8.entities.User;
import in.v8.exceptions.ChatException;
import in.v8.exceptions.MessageException;
import in.v8.exceptions.UserException;
import in.v8.repositores.MessageRepository;
import in.v8.request.SendMessageRequest;

@Service
public class MessageServiceImplementation implements MessageService {
	
	private MessageRepository messageRepository;
	private UserService userService;
	private ChatService chatService;
	
	public MessageServiceImplementation(MessageRepository messageRepository, UserService userService, ChatService chatService) {
		this.messageRepository = messageRepository;
		this.userService = userService;
		this.chatService = chatService;
	}

	@Override
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException {
		User user = userService.findUserById(req.getUserId());
		Chat chat = chatService.findChatByID(req.getChatId());
		
		Message message = new Message();
		message.setUser(user);
		message.setChat(chat);
		message.setContect(req.getContent());
		message.setCreateTimestamp(LocalDateTime.now());
		
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getChatMessages(Integer chatId, User reqUser) throws UserException, ChatException {
		Chat chat = chatService.findChatByID(chatId);
		
		if(!chat.getUsers().contains(reqUser)) {
			throw new UserException("you are noy reletade to this chat");
		}
		
		return messageRepository.findByChatId(chat.getId());
	}

	@Override
	public Message findMessageById(Integer messageId) throws MessageException {
		Optional<Message> messageOptional = messageRepository.findById(messageId);
		
		if(messageOptional.isPresent()) {
			return messageOptional.get();
		}
		
		throw new MessageException("Message not found with id " + messageId);
	}

	@Override
	public void deleteMessage(Integer messageId, User reqUser) throws UserException, MessageException {
		Message message = findMessageById(messageId);
		
		if (message.getUser().getId().equals(reqUser.getId())) {
			messageRepository.deleteById(messageId);
		}
		
		throw new UserException("You can't delete another user message " + reqUser.getFullName());
	}

}
