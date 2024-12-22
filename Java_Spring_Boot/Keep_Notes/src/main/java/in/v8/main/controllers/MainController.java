package in.v8.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "index"; // Matches index.jsp in /WEB-INF/view/
    }
    
    @GetMapping("/register")
    public String registerPage() {
    	return "register";
    }
    
    @GetMapping("/login")
    public String loginPage() {
    	return "login";
    }
    
    @GetMapping("/profile")
    public String profilePage() {
    	return "profile";
    }
}
