package spring.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController  {
//	@RequestMapping("/")
//	public String home() {
//		return "index"; // This index is `index.jsp` file nu name and return value same hovi joye
//	}
//	@RequestMapping("/index")
//	public String indexPage() {
//		return ""; // This should match a JSP file like `index.jsp`
//	}
	@RequestMapping(value = "/helloPage", method = RequestMethod.GET) // this annotation accept all type of request, You can set methods like get, post
//	@GetMapping("/helloPage") // same as in index.jsp file present "Open hello page" link href attribute value:- href="helloPage"
	public ModelAndView openHelloPage() {
		System.out.println("openHelloPage() methos exituted. it minas Opened Hello page...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello"); // This should match a JSP file like `hello.jsp`
		return mav; // Corresponds to hello.jsp
	}

	@GetMapping("/aboutUsPage") // same as in index.jsp file present "About Us" link href attribute value:- href="aboutUsPage"
	public String openAboutUsPage() {
	    return "aboutUs"; // Corresponds to aboutUs.jsp // This should match a JSP file like `aboutUs.jsp`
	}
}
