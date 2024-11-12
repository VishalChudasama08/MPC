package in.v8.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.v8.main.entities.Users;
import in.v8.main.repository.DbOperations;

@SpringBootApplication
public class SpringBootProject11HibernateIndustryCodingStyleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProject11HibernateIndustryCodingStyleApplication.class, args);
		
		DbOperations dbOperations = context.getBean(DbOperations.class);
		Users user = dbOperations.getUserDetails(1L);
		
		if(user != null) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		} else {
			System.out.println("User Not Found");
		}
	}

}
