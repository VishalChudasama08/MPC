package in.v8.main.constrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.v8.main.entities.User;
import in.v8.main.services.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/RegisterFrom") 
	public String openRegisterFrom(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("RegisterFormSubmit")
	public String submitRegisterForm(@ModelAttribute("user") User user, Model model) {
		Boolean status = userService.registerUser(user);
		
		if (status) {
			model.addAttribute("SuccessMsg", "User register successfullay");
		} else {
			model.addAttribute("ErrorMsg", "User not register due to some error");
		}
		return "register";
	}
	
	@GetMapping("/LoginForm")
	public String openLoninPage(Model model) {
		model.addAttribute("enterUser", new User());
		return "login";
	}
	
	@PostMapping("/Profile")
	private String submitLoginPage(@ModelAttribute("enterUser") User user, Model model) {
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		if (validUser != null) {
			model.addAttribute("UserName", validUser.getName());
			return "profile";
		} else {
			model.addAttribute("ErrorMsg", "Email or Password didnt matched.");
			return "login";
		}
	}
	
	@GetMapping("/LogoutForm")
	private String openLogoutForm() {
		return "login";
	}
}
