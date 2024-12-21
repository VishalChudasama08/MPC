package in.v8.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.main.entities.Notes;
import in.v8.main.services.NotesService;

@RestController
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@PostMapping("/api/note/addNote")
	public String addNote(@RequestBody Notes note, Model model) {  
		int status = notesService.addNote(note);
		if(status == 0) {
			model.addAttribute("ErrorMsg", "Note not created due to same error");
			return "not"; // replace page name 
		} else {
			model.addAttribute("Success", "Note add successfully.");
			return "okay"; // replace page name
		}
	}
	
	@GetMapping("/api/note/fetchAllNotes")
	@ResponseBody
	public ResponseEntity<?> getAllNote() { 
		List<Notes> listNotes = notesService.getAllNotes();
		if (listNotes != null) {
			return ResponseEntity.ok(listNotes);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any note.");
		}
	}
	
	@GetMapping("/api/note/fetchThisNotes/{id}")
	@ResponseBody
	public ResponseEntity<?> getThisNote(@PathVariable Long id) { 
		Optional<Notes> thisNote = notesService.getThisNote(id);
		if (thisNote != null) {
			return ResponseEntity.ok(thisNote);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any note.");
		}
	}
	
	@PutMapping("/api/note/updateNote/{id}")
	public String editNote(@PathVariable Long id, @RequestBody Notes editedNotes, Model model) {  
		int status = notesService.updateNote(editedNotes, id);
		if(status == 0) {
			model.addAttribute("ErrorMsg", "Note not edited due to same error");
			return "not"; // replace page name 
		} else {
			model.addAttribute("Success", "Note edited successfully.");
			return "okay"; // replace page name
		}
	}
	
	@DeleteMapping("/api/note/deleteNote/{id}")
	public String deleteNote(@PathVariable Long id, Model model) {
		String message = notesService.deleteNote(id);
		if (message.equals("Note deleted successfully")) {
			model.addAttribute("Success", message);
			return "okay"; // replace page name 
		} else {
			model.addAttribute("ErrorMsg", message);
		    return "not"; // replace page name 
		}
	}
}
