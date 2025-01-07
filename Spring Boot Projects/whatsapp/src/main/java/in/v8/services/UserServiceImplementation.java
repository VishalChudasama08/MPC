package in.v8.services;

import java.util.List;
import java.util.Optional;

import in.v8.entities.User;
import in.v8.exceptions.UserException;
import in.v8.repositores.UserRepository;
import in.v8.request.UpdataUserRequest;

public class UserServiceImplementation implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
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
	public User findUserProfile(String awt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(Integer userId, UpdataUserRequest req) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
