package in.v8.main.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/openProfile")
	public String openProfilePage(Model model) {
		String name="Vishal";
		model.addAttribute("name", name);
		return "profile";
	}
	@GetMapping("/openConditional")
	public String openConditionalPage(Model model) {
		int number1 = 10;
		int number2 = 20;
		
		model.addAttribute("number1", number1);
		model.addAttribute("number2", number2);
		
		return "conditional";
	}
	@GetMapping("/openLooping")
	public String openLoopingPage(Model model) {
		List<Integer> list = List.of(1,2,3,4,5,6,7,8);
		model.addAttribute("listLoop", list);
		return "looping";
	}
}
