package in.v8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.entities.Users;
import in.v8.services.UsersService;

@RestController
public class UsersConstoller {
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/")
	private String okay() {
		System.out.println("Yesss");
		return "index";
	}
	
	@PostMapping("/register")
	private ResponseEntity<Users> registerUser(@RequestBody Users user) {
		System.out.println("Register page open");		
		return ResponseEntity.ok(usersService.addUser(user));
//		Boolean status = usersService.addUser(user);
//		if (status) {
//			return ResponseEntity.ok("Register Successfully");
//		} else {
//			return ResponseEntity.ok("Not Register due to same error");
//		}
	}
}
