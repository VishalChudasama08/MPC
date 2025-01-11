package in.v8.services;

import java.util.List;

import in.v8.entities.User;
import in.v8.exceptions.UserException;
import in.v8.request.UpdataUserRequest;

public interface UserService {
	
	public User findUserById(Integer id) throws UserException;
	
	public User findUserProfile(String awt) throws UserException;
	
	public User updateUser(Integer userId, UpdataUserRequest req) throws UserException;
	
	public List<User> searchUser(String query);
}
