package in.v8.main.services;

import in.v8.main.entities.Users;

public interface UserService {
	public int createUser(Users user);
	public Users login(String email, String password);
	public Users updateUser(Long id, Users newUser);
	public String deleteUser(Long id);
}
