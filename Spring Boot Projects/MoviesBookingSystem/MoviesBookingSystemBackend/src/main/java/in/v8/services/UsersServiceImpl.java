package in.v8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.v8.entities.Users;
import in.v8.repositores.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	// Encrypt password
	private String encryptPassword(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}
	
	// Verify password
	private boolean verifyPassword(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public Users addUser(Users newUser) {
//		return usersRepository.save(newUser);
		newUser.setPassword(encryptPassword(newUser.getPassword()));
		try {
			return usersRepository.save(newUser);
//			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
