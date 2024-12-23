package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import in.v8.main.entities.Notes;

public interface NotesService {
	public int addNote(Notes note);
	public List<Notes> getAllNotesByUserId(Long userId);
//	public Users login(String email, String password);
	public Optional<Notes> getThisNote(Long id);
	public int updateNote(Notes editedNote, Long id);
	public String deleteNote(Long id);
}
