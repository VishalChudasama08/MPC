package in.v8.main.services;

import java.util.List;

import in.v8.main.entities.Notes;

public interface NotesService {
	public int addNote(Notes note);
	public List<Notes> getAllNotesByUserId(Long userId);
	public Notes getThisNote(Long id);
	public int updateNote(Notes editedNote, Long id);
	public String deleteNote(Long id);
	public int updateBGColor(Long id, String color);
	public int updatePinStatus(Long id, Boolean pinned);
}
