package in.v8.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.v8.main.entities.Student;import in.v8.main.services.StudentService;
import in.v8.main.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootProject13DataJpaCrudOperationsWithMysqlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProject13DataJpaCrudOperationsWithMysqlApplication.class, args);
		StudentServiceImpl studentServiceImpl = context.getBean(StudentServiceImpl.class);
		
		//------------------------------ insert operations ------------------------------
//		Student std = new Student();
////		std.setName("Vishal");
////		std.setRollno(18);
////		std.setMarks(98.88f);
//		
//		std.setName("Raju");
//		std.setRollno(24);
//		std.setMarks(97.77f);
//		
//		boolean status = studentServiceImpl.addStudentDetails(std);
//		if (status) {
//			System.out.println("Student Details inserted successfuly");
//		} else {
//			System.out.println("Student Details not inserted due to same error");
//		}
		
		//------------------------------ select operations ------------------------------
		//-------------- get All data --------------
		List<Student> stdList = studentServiceImpl.getAllStudentsDitails();
		for(Student std : stdList) {
			std.displayAllDetails();
		}
		//-------------- get One Row --------------
//		Student std = studentServiceImpl.getStudentDetails(3L);
//		if (std != null) {
//			std.displayAllDetails();
//		} else {
//			System.out.println("Student not found");
//		}
		
		//------------------------------ update operations ------------------------------
//		boolean status = studentServiceImpl.updateStudentDetails(1L, 88.88F);
//		if (status) {
//			System.out.println("Student Details Update successfuly");
//		} else {
//			System.out.println("Student Details not Update due to same error");
//		}
		
		//------------------------------ delete operations ------------------------------
//		boolean status = studentServiceImpl.deleteStudentDetails(2L);
//		if (status) {
//			System.out.println("Student Details Delete successfuly");
//		} else {
//			System.out.println("Student Details not Delete due to same error");
//		}
	}
}
