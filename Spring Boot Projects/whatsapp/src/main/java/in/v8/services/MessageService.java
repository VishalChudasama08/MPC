package in.v8.services;

import java.util.List;

import in.v8.entities.Message;
import in.v8.entities.User;
import in.v8.exceptions.ChatException;
import in.v8.exceptions.MessageException;
import in.v8.exceptions.UserException;
import in.v8.request.SendMessageRequest;

public interface MessageService {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException; 
	
	public List<Message> getChatMessages(Integer chatId, User reqUser) throws UserException, ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public void deleteMessage(Integer messageId, User reqUser) throws UserException, MessageException;
	
}
