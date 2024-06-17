package spring07.constructor.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring07.setter.beans.Student;
import spring07.setter.configuration.SpringConfigurationSetter;

public class Main {
    public static void main(String [] argv){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationSetter.class);

        Student std = (Student) context.getBean(Student.class);
        std.display();
    }
}
