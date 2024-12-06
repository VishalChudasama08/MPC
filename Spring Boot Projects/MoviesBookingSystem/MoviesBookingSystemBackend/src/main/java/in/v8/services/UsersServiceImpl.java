package in.v8.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.v8.entities.UsersEntity;
import in.v8.exceptions.custom_exception.UserNotFoundByEmailException;
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
	public UsersEntity addUser(UsersEntity newUser) {
		newUser.setPassword(encryptPassword(newUser.getPassword()));
		return usersRepository.save(newUser);
	}

	@Override
	public List<UsersEntity> findAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public UsersEntity fingThisUser(Long id) {
		// if user not found than throw custom UserNotFoundByEmailException with message
		return usersRepository.findById(id).orElseThrow(()-> new UserNotFoundByEmailException("User not found."));
	}

	@Override
	public UsersEntity updateUserDetail(Long id, UsersEntity editedUser) {
	    UsersEntity oldUser = fingThisUser(id);

	    if (editedUser.getFirstName() != null && !editedUser.getFirstName().equals(oldUser.getFirstName())) {
	        oldUser.setFirstName(editedUser.getFirstName());
	    }
	    if (editedUser.getLastName() != null && !editedUser.getLastName().equals(oldUser.getLastName())) {
	        oldUser.setLastName(editedUser.getLastName());
	    }
	    if (editedUser.getEmail() != null && !editedUser.getEmail().equals(oldUser.getEmail())) {
	        oldUser.setEmail(editedUser.getEmail());
	    }
	    if (editedUser.getMobileNumber() != null && !editedUser.getMobileNumber().equals(oldUser.getMobileNumber())) {
	        oldUser.setMobileNumber(editedUser.getMobileNumber());
	    }

	    // Encrypt and update the new password only if provided (password update is use)
	    if (editedUser.getPassword() != null && !editedUser.getPassword().isBlank()) {
	        oldUser.setPassword(encryptPassword(editedUser.getPassword()));
	    }

	    return usersRepository.save(oldUser); // all fields update in oldUser Object. Save the updated user that is oldUser
	}

	@Override
	public void deletUsers(Long id) {
		fingThisUser(id); // only for if user not found than showing that message 
		usersRepository.deleteById(id);
	}

}
