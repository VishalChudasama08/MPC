package in.v8.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.v8.main.entities.User;
import in.v8.main.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/openRegister")
	public String openRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/registerSubmit")
	public String registerFormSubmit(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerForm(user);
		if (status) {
			model.addAttribute("success", "User register successefully");
		} else {
			model.addAttribute("error", "User not register due to same error");
		}	
		return "register";	
	}
	
	@GetMapping("/openLogin")
	public String openLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/openProfile")
	public String loginFromSubmir(@ModelAttribute("user") User user, Model model) {
		User validUser = userService.loginForm(user.getEmail(), user.getPassword());
		
		if (validUser != null) {
			model.addAttribute("userName", validUser.getName());
			return "profile";
		} else {
			model.addAttribute("error", "Email and Password didn't matched");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String clickLogout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false); // write 'false' to get same session, not provide 'false' than this return new session
		
		if (session != null) {
			session.invalidate(); // destroy session
		}
		return "redirect:/openLogin";
	}
}
