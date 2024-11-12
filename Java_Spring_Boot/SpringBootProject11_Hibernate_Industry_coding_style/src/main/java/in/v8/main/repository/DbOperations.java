package in.v8.main.repository;

import in.v8.main.entities.Users;

public interface DbOperations {
	public Users getUserDetails(Long id);
}