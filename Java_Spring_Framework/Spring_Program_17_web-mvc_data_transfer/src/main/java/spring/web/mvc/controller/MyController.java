package spring.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.web.mvc.beans.User;

@Controller
public class MyController {
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

	@GetMapping("/aboutUsPage") // value same as in index.jsp file present "About Us" link href attribute value:- href="aboutUsPage"
	public String openAboutUsPage() {
	    return "aboutUs"; // Corresponds to aboutUs.jsp // This should match a JSP file like `aboutUs.jsp`
	}
	
	@GetMapping("/form") // value same as in index.jsp file present "My From" link href attribute value:- href="form"
	public String openMyForm() {
	    return "myForm"; // Corresponds to myFrom.jsp // This should match a JSP file like `myFrom.jsp`
	}

//	@PostMapping("/formSubmit") // value same as in myForm.jsp file present submit form action attribute value:- action="formSubmit"
//	public String openProfilePage(
//									@RequestParam("name") String name, // using this annotation get form submit values 
//									@RequestParam("email") String email,
//									@RequestParam("number") String number,
//									Model model
//									/* Model is an interface in Spring MVC which allows controllers to pass data to the view layer for rendering.
//									 * It acts as a container for attributes, enabling controller to share data with views and facilitate dynamic content generation */
//								 ) {
//		System.out.println("Name: "+ name);
//		System.out.println("Email: "+ email);
//		System.out.println("Number: "+ number);
//		
//		model.addAttribute("model_name", name);
//		model.addAttribute("model_email", email);
//		model.addAttribute("model_number", number);
//		
//		return "profile";
//	}
	
	
	// use bean class to store all data in this class and sent class object only 
	
//	@PostMapping("/formSubmit") // value same as in myForm.jsp file present submit form action attribute value:- action="formSubmit"
//	public String openProfilePage(
//									@RequestParam("name") String name, // using this annotation get form submit values 
//									@RequestParam("email") String email,
//									@RequestParam("number") String number,
//									Model model
//									/* Model is an interface in Spring MVC which allows controllers to pass data to the view layer for rendering.
//									 * It acts as a container for attributes, enabling controller to share data with views and facilitate dynamic content generation */
//								 ) {
//		System.out.println("Name: "+ name);
//		System.out.println("Email: "+ email);
//		System.out.println("Number: "+ number);
//		
//		User user = new User();
//		user.setName(name);
//		user.setEmail(email);
//		user.setNumber(number);
//		
//		model.addAttribute("model_user", user);
//		// sent object not send all one-by-one this is batter method
//		
//		return "profile";
//	}
	
	
	// if in form many field present than user @ModelAttribute annotation to set all value in class object (here User class user object)
	@PostMapping("/formSubmit") // value same as in myForm.jsp file present submit form action attribute value:- action="formSubmit"
	public String openProfilePage(@ModelAttribute User user) { /* In Spring MVC, @ModelAttribute binds request parameters or from data into java object properties.
	 															* It's used in controller methods to capture and convert incoming data into model attributes.
	 															* This simplifies data binding and allows seamless integration of user inputs with java objects in web application */
		System.out.println("Name: "+ user.getName()); // all form submits value store/set in user class object  
		System.out.println("Email: "+ user.getEmail());
		System.out.println("Number: "+ user.getNumber());
		
		return "profile";
	}
}
