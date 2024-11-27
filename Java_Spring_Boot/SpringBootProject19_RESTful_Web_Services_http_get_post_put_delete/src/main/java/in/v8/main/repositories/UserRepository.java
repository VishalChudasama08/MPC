package in.v8.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.v8.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
