package in.v8.main.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.v8.main.entities.Users;
import in.v8.main.services.UserService;

@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	@ResponseBody
	public Map<String, String> addUser(@RequestBody Users user) { // use @RequestBody annotation to get client provide data 
		Map<String, String> response = new HashMap<>();
		int status = userService.createUser(user);
		if (status == 0) {
	        response.put("status", "error");
	        response.put("message", "The provided email is already registered.");
	    } else {
	        response.put("status", "success");
	        response.put("message", "User registered successfully.");
	    }
		return response;
	}
	
	@PutMapping("/updateUser/{id}")
	@ResponseBody
	public Map<String, String> updateUser(@PathVariable Long id, @RequestBody Users user) {
		Map<String, String> response = new HashMap<>();
		Users newUser = userService.updateUser(id, user);
		if (newUser != null) {
			response.put("status", "success");
	        response.put("message", "User Details Update successfully.");
	    } else {
	    	response.put("status", "error");
	        response.put("message", "User Details not updated due to some error");
	    }
		return response;
	}

	
	@PostMapping("/login")
	@ResponseBody
	public Map<String, String> getOneUser(@RequestBody Users user, HttpSession session) {
		Map<String, String> response = new HashMap<>();
		Users validUser = userService.login(user.getEmail(), user.getPassword());
		if (validUser != null) {
			response.put("status", "success");
			response.put("message", "User loging successfully.");
			response.put("UserName", validUser.getFirstName());
			response.put("UserId", String.valueOf(validUser.getId()));
			session.setAttribute("loggedInUser", validUser);
		} else {
			response.put("status", "error");
			response.put("message", "Email or Password didn't matched.");
		}
		return response;
	}
	
	@DeleteMapping("deleteUser/{id}")
	@ResponseBody
	public Map<String, String> deleteUser(@PathVariable Long id, Model model) {
		Map<String, String> response = new HashMap<>();
		String message = userService.deleteUser(id);
		if (message.equals("User deleted successfully")) {
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
