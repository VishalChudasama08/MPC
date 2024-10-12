package in.v8.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	@ResponseBody
	private String printHello() {
		String para1 = "<br> This Project Created From \"Spring initializr\". and import in 'Spring Tool Suite IDE'";
		String link = "<br> <a href='https://start.spring.io/' target='_black'>Spring initializr<a>";
		String para2 = " Create and Dowonload Project Than import in any IDE like 'Spring Tool Suite IDE', 'Eclipce IDE'";
		String data = para1 + link + para2;
		return "Hello Vishal" + data ;
	}
}
