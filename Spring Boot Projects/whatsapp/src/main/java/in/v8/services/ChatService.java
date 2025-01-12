package in.v8.services;

import java.util.List;

import in.v8.entities.Chat;
import in.v8.entities.User;
import in.v8.exceptions.ChatException;
import in.v8.exceptions.UserException;
import in.v8.request.GroupChatRequest;

public interface ChatService {
	
	public Chat createChat(User reqUser, Integer UserId2) throws UserException;
	
	public Chat findChatByID(Integer chatId) throws ChatException;
	
	public List<Chat> findAllChatByUserId(Integer userId) throws UserException;
	
	public Chat createGroup(GroupChatRequest reqGroup, User reqUser) throws UserException;
	
	public Chat addUserToGroup(Integer userId, Integer chatId, User reqUser) throws UserException, ChatException;
	
	public Chat renameGroup(Integer chatId, String newName, User reqUser) throws UserException, ChatException;
	
	public Chat removeFromGroup(Integer chatId, Integer userId, User reqUser) throws UserException, ChatException;
	
	public void deleteChat(Integer chatId, Integer userId) throws UserException, ChatException;
}
