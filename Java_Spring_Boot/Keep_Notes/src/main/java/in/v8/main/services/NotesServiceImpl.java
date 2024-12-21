package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.v8.main.entities.Notes;
import in.v8.main.repositories.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {
	
	@Autowired
	private NotesRepository notesRepository;

	@Override
	public int addNote(Notes note) {
		notesRepository.save(note);
		return 1;
	}

	@Override
	public List<Notes> getAllNotes() {
		return notesRepository.findAll();
	}

	@Override
	public Optional<Notes> getThisNote(Long id) {
		return notesRepository.findById(id);
	}

	@Override
	public int updateNote(Notes editedNotes, Long id) {
		Notes oldNote = notesRepository.findById(id).orElse(null);
		if(oldNote != null) { // here note exist it means that id note exist and id present in that object (means oldNote.id is not null) 
			editedNotes.setId(oldNote.getId()); // set oldNote id to editedNote id to do update
			notesRepository.save(editedNotes); // if id exist in provided entity object than JPA do update
			return 1; 
		} else {
			return 0;
		}
	}

	@Override
	public String deleteNote(Long id) {
		if (notesRepository.existsById(id)) {
			notesRepository.deleteById(id);
			return "Note deleted successfully";
		} else {			
			return "Note not deleted or note not Found.";
		}
	}
//
//	@Override
//	public Users login(String email, String password) {
//		Users validUser = userRepository.findByEmail(email);
//		
//		if (validUser != null && validUser.getPassword().equals(password)) {
//			return validUser;
//		} else {
//			return null;
//		}
//	}
}
