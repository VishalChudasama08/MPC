package in.v8.main.services;

import in.v8.main.entities.User;

public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password);
}
