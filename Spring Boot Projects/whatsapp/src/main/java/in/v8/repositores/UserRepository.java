package in.v8.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import in.v8.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
