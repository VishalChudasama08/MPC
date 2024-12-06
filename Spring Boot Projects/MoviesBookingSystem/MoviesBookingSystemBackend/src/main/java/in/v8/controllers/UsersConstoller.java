package in.v8.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.v8.entities.UsersEntity;
import in.v8.services.UsersService;
import in.v8.validation.ValidationGroups;

@RestController
@RequestMapping("/user")
public class UsersConstoller {
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/register")
	private ResponseEntity<String> registerUser(@Validated(ValidationGroups.Create.class) @RequestBody UsersEntity newUser) {
		System.out.println("Register page open");
		usersService.addUser(newUser);
		return ResponseEntity.ok().body("User registered successfully!");
	}
	
	@GetMapping("/allUsers")	
	private ResponseEntity<List<UsersEntity>> getAllUsers(){
		return ResponseEntity.ok().body(usersService.findAllUsers());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<UsersEntity> getThisUser(@PathVariable Long id){
		return ResponseEntity.ok().body(usersService.fingThisUser(id));
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<String> editUser(@PathVariable Long id, @Validated(ValidationGroups.Update.class) @RequestBody UsersEntity editedUsers){
		usersService.updateUserDetail(id, editedUsers);
		return ResponseEntity.ok().body("User details updated successfully");
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> deleteUser(@PathVariable Long id){
		usersService.deletUsers(id);
		return ResponseEntity.ok().body("User deleted successfully");
	}
}
