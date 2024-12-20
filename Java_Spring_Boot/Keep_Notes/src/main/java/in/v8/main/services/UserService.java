package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import in.v8.main.entities.Users;

public interface UserService {
	public Users createUser(Users user);
	public List<Users> getAllUsers();
	public Users login(String email, String password);
	public Optional<Users> getUser(Long id);
	public Users updateUser(Users newUser, Long id);
	public String deleteUser(Long id);
}