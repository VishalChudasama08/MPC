package spring07.setter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring07.setter.beans.Student;
import spring07.setter.configuration.SpringConfigurationSetter;

public class Main {
    public static void main(String [] argv){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationSetter.class);

        Student std = (Student) context.getBean("returnStdObj"); // returnStdObj --> in configuration file Student class method name
        std.display();
    }
}
