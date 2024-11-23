package in.v8.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.v8.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
