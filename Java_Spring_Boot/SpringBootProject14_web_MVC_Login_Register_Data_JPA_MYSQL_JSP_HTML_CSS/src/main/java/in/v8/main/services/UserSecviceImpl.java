package in.v8.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.v8.main.entities.User;
import in.v8.main.repositories.UserRepository;

@Service
public class UserSecviceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean registerUser(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User loginUser(String email, String password) {
		User validUser = userRepository.findByEmail(email);
		
		if (validUser != null && validUser.getPassword().equals(password)) {
			return validUser;
		} else {
			return null;
		}
	}
}
