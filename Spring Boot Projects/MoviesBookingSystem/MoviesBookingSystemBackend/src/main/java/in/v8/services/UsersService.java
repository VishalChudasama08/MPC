package in.v8.services;

import java.util.List;

import in.v8.entities.UsersEntity;

public interface UsersService {
	public UsersEntity addUser(UsersEntity newUser);
	public List<UsersEntity> findAllUsers();
	public UsersEntity fingThisUser(Long id);
	public UsersEntity updateUserDetail(Long id, UsersEntity editedUser);
	public void deletUsers(Long id);
}
