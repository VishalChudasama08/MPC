package javaconfiguration.constructor.main;

import javaconfiguration.constructor.beans.Student;
import javaconfiguration.constructor.configuration.JavaConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        Student std = (Student) context.getBean("studentObj");
        std.dispaly();
    }
}
