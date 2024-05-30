package spring06.setter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring06.setter.beans.Student;

public class Main {
    public static void main(String [] argv){
        String config_file_location = "spring06/setter/resources/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config_file_location);

        Student std = (Student) context.getBean("stdId");
        std.display();
    }
}
