package in.v8.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

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
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        System.out.print("remove session all data\n");
        return "redirect:/login"; // Redirect to login page
    }

    @GetMapping("/NotesHome")
    public String openNotesHomePage() {
    	return "NotesHome";
    }
    
    @GetMapping("/Profile")
    public String openProfilePage() {
    	return "Profile";
    }

    @GetMapping("/About")
    public String openAboutPage() {
    	return "About";
    }
}
