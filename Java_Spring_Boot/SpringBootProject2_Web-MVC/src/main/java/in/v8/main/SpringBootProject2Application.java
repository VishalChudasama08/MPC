package in.v8.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.v8.main.controller.MyController;

@SpringBootApplication
public class SpringBootProject2Application {

	public static void main(String[] args) { // V4
		SpringApplication.run(SpringBootProject2Application.class, args);
		MyController controller = new MyController();
		controller.printHello();
	}
}
