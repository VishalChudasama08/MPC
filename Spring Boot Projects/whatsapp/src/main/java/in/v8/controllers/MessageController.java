package in.v8.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.entities.Message;
import in.v8.entities.User;
import in.v8.exceptions.ChatException;
import in.v8.exceptions.MessageException;
import in.v8.exceptions.UserException;
import in.v8.request.SendMessageRequest;
import in.v8.response.ApiResponse;
import in.v8.services.MessageService;
import in.v8.services.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	private MessageService messageService;
	private UserService userService;
	
	public MessageController(MessageService messageService, UserService userService) {
		this.messageService = messageService;
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Message> sendMeaageHandler(@RequestBody SendMessageRequest req,  @RequestHeader("Authorization") String jwt) throws UserException, ChatException{
		User user = userService.findUserProfile(jwt);
		
		req.setUserId(user.getId());
		Message message = messageService.sendMessage(req);
		
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}
	
	@GetMapping("/chat/{chatId}")
	public ResponseEntity<List<Message>> getChatMessagesHandler(@PathVariable Integer chatId,  @RequestHeader("Authorization") String jwt) throws UserException, ChatException{
		User user = userService.findUserProfile(jwt);
		
		List<Message> messageList = messageService.getChatMessages(chatId, user);
		
		return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
	}
	
	@DeleteMapping("/{messageId}")
	public ResponseEntity<ApiResponse> deleteMessageHandler(@PathVariable Integer messageId,  @RequestHeader("Authorization") String jwt) throws UserException, MessageException{
		User user = userService.findUserProfile(jwt);
		
		messageService.deleteMessage(messageId, user);
		
		ApiResponse response = new ApiResponse("Message deleted successfully ", true);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
	
}
