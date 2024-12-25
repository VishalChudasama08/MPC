package in.v8.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String openHomePage() {
        return "index"; // Matches index.jsp in /WEB-INF/view/
    }
    
    @GetMapping("/register")
    public String openRegisterPage() {
    	return "register";
    }
    
    @GetMapping("/login")
    public String openLoginPage() {
    	return "login";
    }
    
    @GetMapping("/NotesHome")
    public String openNotesHomePage() {
    	return "NotesHome";
    }
    
    @GetMapping("/profile")
    public String openProfilePage() {
    	return "profile";
    }
}
