package in.v8.main.services;

import in.v8.main.entities.User;

public interface UserService {
	public boolean registerForm(User user);
	public User loginForm(String email, String password);
}
