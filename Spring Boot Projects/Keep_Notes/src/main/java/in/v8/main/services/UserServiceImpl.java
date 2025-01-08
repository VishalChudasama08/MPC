package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.v8.main.entities.Users;
import in.v8.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public int createUser(Users user) {
		if(userRepository.existsByEmail(user.getEmail())) { // check email is exists or not
			return 0;
		} else {
			userRepository.save(user);
			return 1;
		}
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<Users> getUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Users updateUser(Long id, Users newUser) {
		Users user = userRepository.findById(id).orElse(null);
		if(user != null) { // here user exist it means that id user exist and id present in that object (means user.id is not null) 
			newUser.setId(user.getId());
			newUser.setPassword(user.getPassword());
			newUser.setCreateDate(user.getCreateDate());
			return userRepository.save(newUser); // if id exist in provided entity object than JSP do update
		} else {
			throw new RuntimeException("User not found with id:"+ id);
		}
	}

	@Override
	public String deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "User deleted successfully";
		} else {			
			return "User not deleted or User not Found."; // Check provided id's user exist!
		}
	}

	@Override
	public Users login(String email, String password) {
		Users validUser = userRepository.findByEmail(email);
		
		if (validUser != null && validUser.getPassword().equals(password)) {
			validUser.setPassword(""); // remove password
			validUser.setCreateDate(null); // remove date
			return validUser;
		} else {
			return null;
		}
	}
}
