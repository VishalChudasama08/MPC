package javaconfiguration.setter.main;

import javaconfiguration.setter.beans.Student;
import javaconfiguration.setter.configuration.JavaConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        Student std = (Student) context.getBean("studentObj");
        std.dispaly();
    }
}
