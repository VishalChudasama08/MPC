package in.v8.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	@ResponseBody
	public String printHello() {
		String data = "Hello Vishal !, This is \"Spring Boot Web Application\"";
		String data2 = "<br>For Chenge topcat server port number <br> write this \"server.port=8181\" \t on \'application.properties\' file. This file preject in src/test/resources";
		return data + data2;
	}
}
