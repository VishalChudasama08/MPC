package in.v8.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import in.v8.config.TokenProvider;
import in.v8.entities.User;
import in.v8.exceptions.UserException;
import in.v8.repositores.UserRepository;
import in.v8.request.UpdataUserRequest;

@Service
public class UserServiceImplementation implements UserService {
	
	private UserRepository userRepository;
	private TokenProvider tokenProvider;
	
	public UserServiceImplementation(UserRepository userRepository, TokenProvider tokenProvider) {
		this.userRepository = userRepository;
		this.tokenProvider = tokenProvider;
	}

	@Override
	public User findUserById(Integer id) throws UserException {
		Optional<User> optUser = userRepository.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}
		throw new UserException("User not found with id " + id);
	}

	@Override
	public User findUserProfile(String awt) throws UserException {
		String email = tokenProvider.getEmailFromToken(awt);
		if(email == null) {
			throw new BadCredentialsException("recieved invalid token---");
		}
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UserException("user not found with email " + email);
		}
		return user;
	}

	@Override
	public User updateUser(Integer userId, UpdataUserRequest req) throws UserException {
		User user = findUserById(userId);
		
		if(user.getFullName() != null) {
			user.setFullName(req.getFull_name());
		}
		if(user.getProfilePicture() != null) {
			user.setProfilePicture(req.getProfile_picture());
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> searchUser(String query) {
		List<User> users = userRepository.searchUsers(query);
		return users;
	}
	
}
