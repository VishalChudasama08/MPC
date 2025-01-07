package in.v8.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public ResponseEntity<String> Welcome(){
		return new ResponseEntity<String>("Welcome", HttpStatus.OK);
	}
}
