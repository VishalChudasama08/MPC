package in.v8.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.v8.main.entities.Users;
import in.v8.main.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user/createUser")
	public String addUser(@RequestBody Users user, Model model) { // use @RequestBody annotation to get client provide data 
		int status = userService.createUser(user);
		if(status == 0) {
			model.addAttribute("ErrorMsg", "The provided email is already registered.");
			return "register";
		} else {
			model.addAttribute("Success", "User registered successfully.");
			return "login";
		}
	}
	
	@PostMapping("/api/user/login")
	public String getOneUser(@RequestBody Users user, Model model) { 
		Users validUser = userService.login(user.getEmail(), user.getPassword());
		if (validUser != null) {
			model.addAttribute("UserName", validUser.getFirstName()); // set model Attribute to get UserName in profile.jsp page
			model.addAttribute("UserId", validUser.getId());
			return "profile";
		} else {
			model.addAttribute("ErrorMsg", "Email or Password didn't matched.");
			return "login";
		}
	}
	
	@DeleteMapping("/api/user/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		String message = userService.deleteUser(id);
		if (message.equals("User deleted successfully")) {
			model.addAttribute("Success", message);
			return "register";
		} else {
			model.addAttribute("ErrorMsg", message);
		    return "profile"; // not going any ware return same page name 
		}
	}
}
