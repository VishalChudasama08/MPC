package in.v8.main.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.v8.main.beans.Student;

@Configuration
public class AppConfiguration {
	@Bean
	public CommandLineRunner cmdLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				stdBean1().printDetails();
				
				System.out.println("---------------");
				
				stdBean2().printDetails();
			}
		};
	}
	
	@Bean
	public Student stdBean1() {
		return new Student("Vishal", 8, 76.08f);
	}
	
	@Bean
	public Student stdBean2() {
		return new Student("Nitin", 88, 88.07f);
	}
}

