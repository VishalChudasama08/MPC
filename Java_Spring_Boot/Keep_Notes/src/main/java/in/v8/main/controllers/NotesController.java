package in.v8.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.main.entities.Notes;
import in.v8.main.services.NotesService;

@RestController
@RequestMapping("/api/note")
public class NotesController {
	
	@Autowired
	private NotesService notesService;
	
	@PostMapping("/addNote") // for add note
	@ResponseBody
	public Map<String, String> addNote(@RequestBody Notes note) {
		Map<String, String> response = new HashMap<>();
//		System.out.println(note.get);
		int status = notesService.addNote(note);
		if (status == 0) {
	        response.put("status", "error");
	        response.put("message", "Note not created due to same error");
	    } else {
	        response.put("status", "success");
	        response.put("message", "Note add  successfully.");
	    }
		return response;
	}
	
	@GetMapping("/{userId}") // for fetch All Notes, id is use id
	@ResponseBody
	public ResponseEntity<?> getAllNote(@PathVariable Long userId) { 
		List<Notes> listNotes = notesService.getAllNotesByUserId(userId);
		if (listNotes != null && !listNotes.isEmpty()) {
			return ResponseEntity.ok(listNotes);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No notes found for this user.");
		}
	}
	
	@PutMapping("/{id}") // for update note
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
	
	@DeleteMapping("/{id}") // for delete note
	@ResponseBody
	public Map<String, String> deleteNote(@PathVariable Long id, Model model) {
		Map<String, String> response = new HashMap<>();
		String message = notesService.deleteNote(id);
		if (message.equals("Note deleted successfully")) {
			model.addAttribute("Success", message);
			response.put("message", message);
		} else {
			model.addAttribute("ErrorMsg", message);
			response.put("message", message);
		}
		return response;
	}
}
