package in.v8.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject1Application.class, args);
		
		System.out.println("Hello Vishal ! This is Spring Boot First Pgoram");
		System.out.println("This is Spring Boot Standalone Application.");
		System.out.println("In Standalone Application Output showing in Console.");
	}

}
