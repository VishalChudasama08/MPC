package in.v8.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	        response.put("message", "Note add successfully.");
	    }
		return response;
	}
	
	@GetMapping("/{userId}") // for fetch All Notes, id is note table useId
	@ResponseBody
	public ResponseEntity<?> getAllNote(@PathVariable Long userId) { 
		List<Notes> listNotes = notesService.getAllNotesByUserId(userId);
		if (listNotes != null && !listNotes.isEmpty()) {
			return ResponseEntity.ok(listNotes);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No notes found for this user.");
		}
	}
	
	@PostMapping("/{id}") // for fetch this Notes
	@ResponseBody
	public ResponseEntity<?> getThisNote(@PathVariable Long id) { 
		Optional<Notes> listNotes = notesService.getThisNote(id);
		if (listNotes != null && !listNotes.isEmpty()) {
			return ResponseEntity.ok(listNotes);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found.");
		}
	}
	
	@PutMapping("/{id}") // for update note
	@ResponseBody
	public Map<String, String> editNote(@PathVariable Long id, @RequestBody Notes editedNote) {
		Map<String, String> response = new HashMap<>();
		int status = notesService.updateNote(editedNote, id);
		if(status == 0) {
			response.put("status", "error");
			response.put("message", "Note not edited due to same error");
		} else {
			response.put("status", "success");
			response.put("message", "Note edited successfully.");
		}
		return response;
	}

	@PutMapping("bgColor/{id}/color") // update color
	@ResponseBody
	public Map<String, String> updateNoteBGColor(@PathVariable Long id, @RequestParam String color){
		Map<String, String> response = new HashMap<>();
		int status = notesService.updateBGColor(id, color);
		if(status > 0) {
			response.put("status", "success");
			response.put("message", status+" note set color successful");
		} else {
			response.put("status", "error");
	        response.put("message", "set color failed");
		}
		return response;
	}
	
	@PutMapping("pin/{id}/pinned") // for update pinned status
	@ResponseBody
	public Map<String, String> updatePinStatus(@PathVariable Long id, @RequestParam Boolean pinned) {
		Map<String, String> response = new HashMap<>();
		int status = notesService.updatePinStatus(id, pinned);
		if(status > 0) {
			response.put("status", "success");
			response.put("message", "Note pinned status update successfully.");
		} else {
			response.put("status", "error");
			response.put("message", "Note pinned status not update due to same error");
		}
		return response;
	}
	
	@DeleteMapping("/{id}") // for delete note
	@ResponseBody
	public Map<String, String> deleteNote(@PathVariable Long id, Model model) {
		Map<String, String> response = new HashMap<>();
		String message = notesService.deleteNote(id);
		if (message.equals("Note deleted successfully")) {
			model.addAttribute("Success", message);
			response.put("status", "success");
			response.put("message", message);
		} else {
			model.addAttribute("ErrorMsg", message);
			response.put("status", "error");
			response.put("message", message);
		}
		return response;
	}
}
