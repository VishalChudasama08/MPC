package spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
//    @RequestMapping("/helloPage") // this annotation accept all type of request
    @GetMapping("/helloPage") // this annotation use get method request only
    public ModelAndView openHelloPage(){
        System.out.println("openHelloPage() method executed.");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello"); // view name (create/ write view name)
        return null;
    }

    @GetMapping("/aboutUs")
    public String openAboutUsPage(){
        return "about-us";
    }
}
