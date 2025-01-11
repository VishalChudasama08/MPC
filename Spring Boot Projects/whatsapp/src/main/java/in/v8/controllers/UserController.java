package in.v8.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.v8.entities.User;
import in.v8.exceptions.UserException;
import in.v8.request.UpdataUserRequest;
import in.v8.response.ApiResponse;
import in.v8.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String token) throws UserException{
		User user = userService.findUserProfile(token);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{searchText}")
	public ResponseEntity<List<User>> searchUserHandler(@PathVariable("searchText") String query){
		List<User> users = userService.searchUser(query);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ApiResponse> updateUserHandler(@RequestBody UpdataUserRequest req, @RequestHeader("Authorization") String token) throws UserException{
		User user = userService.findUserProfile(token);
		userService.updateUser(user.getId(), req);
		
		ApiResponse response = new ApiResponse("User updated successfully", true);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.ACCEPTED);
		
	}
}
