package in.v8.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.v8.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
