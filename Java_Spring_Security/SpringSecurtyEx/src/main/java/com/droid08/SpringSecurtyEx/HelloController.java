package com.droid08.SpringSecurtyEx;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        System.out.println("Get Request Detected. Home page loaded. - this from HelloController.java greet() method System.out.println() line no. ~12");
        String str1 = "Hello. This is Spring Security Tutorial. started at 28-06-2025, 02:30PM from Ahmedabad.<br>";
        String str2 = request.getSession().getId();
        return str1 + str2;
    }
}
