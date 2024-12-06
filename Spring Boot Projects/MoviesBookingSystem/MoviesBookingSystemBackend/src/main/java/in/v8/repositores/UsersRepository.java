package in.v8.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.v8.entities.UsersEntity;


@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long>{
	public Optional<UsersEntity> findByEmail(String email);
}
