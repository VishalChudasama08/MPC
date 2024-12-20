package in.v8.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.main.entities.Users;
import in.v8.main.services.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user/createUser")
	public Users addUser(@RequestBody Users user) { // use @RequestBody annotation to get client provide data 
		return userService.createUser(user);
	}
	
//	@GetMapping("/api/user/getAllUsers")
//	public List<Users> getAllUsers() {
//		return userService.getAllUsers();
//	}
	
	@GetMapping("/api/user/login")
	public String getOneUser(@RequestBody Users user, Model model) { 
		Users validUser = userService.login(user.getEmail(), user.getPassword());
		if (validUser != null) {
			model.addAttribute("UserName", validUser.getFirstName()); // set model Attribute to get UserName in profile.jsp page
			model.addAttribute("UserId", validUser.getId());
			return "profile";
		} else {
			model.addAttribute("ErrorMsg", "Email or Password didnt matched.");
			return "login";
		}
	}
	
	@PutMapping("/api/user/updateUser/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
		Users updatedUser = userService.updateUser(user, id);
		if (id != null && user != null) {
			return ResponseEntity.ok(updatedUser); // .ok(updatedUser) and .ok().body(updatedUser) both are same 
		} else {			
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/api/user/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
}
