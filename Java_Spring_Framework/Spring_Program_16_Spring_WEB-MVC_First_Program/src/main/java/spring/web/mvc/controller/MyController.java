package spring.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
//    @RequestMapping("/hello") // this annotation accept all type of request
    @GetMapping("/hello")
    public String openHelloPage() {
        return "hello"; // Corresponds to hello.jsp
    }

    @GetMapping("/aboutUs")
    public String openAboutUsPage() {
        return "aboutUs"; // Corresponds to aboutUs.jsp
    }
}


