package in.v8.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.v8.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.fullName LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUsers(@Param("query") String query);
}
