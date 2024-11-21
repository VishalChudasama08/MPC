package in.v8.main;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject1Application {

	public static void main(String[] args) { // V4
		SpringApplication.run(SpringBootProject1Application.class, args);
		
		System.out.println("Hello Vishal ! This is Spring Boot First Pgoram");
		System.out.println("This is Spring Boot Standalone Application.");
		System.out.println("In Standalone Application Output showing in Console.");
		
		String springBoot = "What is Spring Boot ? \n" 
				+ "=> Spring Bott is an open-source framework built on top of the Sprint Framework for java developers.\n"
				+ "=> Spring Boot was developed by Pivotel Software (now part of VMware). It was first released in 2024.\n"
				+ "=> In Spring Boot, 'Boot' refers tothe concept of rapo=idly initiating a spring application by handling all essentials set ups and configurations. \n"
				+ "=> Spring Boot makes building Spring applicstion easier and faster.";
		
		String corePrinciples = "Spring Boot Core Principles\n"
				+ "=>Opinionated Defaults:\n"
				+ "\t In Spring Boot, \'opinionated defauls\' refer to pre-configured settings and behaviors designed to simplify development by providing sensible defaults.\n"
				+ "\t These defaults are based on best practices and common use cases, reducing the need for explicit configuration\n\n"
				+ "=>Convention Over Defaults:\n"
				+ "\t Convention over configuration in Spring Boot means that if we follow certin established patterns or conventins, we can achieve a lot @RestController for creating RESTful APTs,\n "
				+ "@Service for service layers, or organizig our code into specific subpackages to enable automatic scannig.\n\n"
				+ "=>Auto-configuratin:\n"
				+ "\t in Spring Boot means setting up components and setting automatically based on project dependencies.\n"
				+ "\t For Egxample, including spring-web configures essentials like the dispatcher servlet and view resolvers for web apps, eliminating manual setup and letting developers focus\n"
				+ "on coding instead of infrastructure.\n\n"
				+ "=>Embedded Servers:";
		System.out.println(springBoot);
		System.out.println(corePrinciples);		
	}
}
