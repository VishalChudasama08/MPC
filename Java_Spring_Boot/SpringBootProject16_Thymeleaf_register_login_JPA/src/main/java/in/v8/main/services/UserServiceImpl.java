package in.v8.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.v8.main.entities.User;
import in.v8.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean registerForm(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User loginForm(String email, String password) {
		User user = userRepository.findByEmail(email);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} 
		return null;
	}

}
