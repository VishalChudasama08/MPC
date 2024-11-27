package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import in.v8.main.entities.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUser(Long id);
	public User updateUser(User newUser, Long id);
	public String deleteUser(Long id);
}
