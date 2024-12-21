package in.v8.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.v8.main.entities.Notes;


@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
}
