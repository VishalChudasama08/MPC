package spring03.program03.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring03.program03.beans.Student;

public class Using_Annotation_with_Java_and_XML_ConfigurationFile {
    public static void main(String[] args){
        // Using XML configuration File
//        String resource_path_file = "spring03/program03/configuration/applicationContext.xml";
//        ApplicationContext context = new ClassPathXmlApplicationContext(resource_path_file);

        // Using java configuration File
        ApplicationContext context = new AnnotationConfigApplicationContext(Student.class);

        // use any one Configuration file
        Student std = (Student) context.getBean("student"); // student --> @Component annotation used class name in small later (because object name is not capital later)
        std.display();
    }
}
