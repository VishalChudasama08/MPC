package in.v8.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.main.entities.User;
import in.v8.main.services.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) { // use @RequestBody annotation to get client provide data 
		return userService.createUser(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/getThisUser/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable Long id) { // ResponseEntity<T> class use provide response and status like ok, not found,...
		User user = userService.getUser(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user); // provide status ok with response entity 
		} else {
			return ResponseEntity.notFound().build(); // provide 404 not found error
		}
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User updatedUser = userService.updateUser(user, id);
		if (id != null && user != null) {
			return ResponseEntity.ok(updatedUser); // .ok(updatedUser) and .ok().body(updatedUser) both are same 
		} else {			
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
}
