package xmlconfiguration.constructor.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlconfiguration.constructor.beans.Student;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/xmlconfiguration/constructor/configuration/applicationContext.xml");
        Student std = (Student) context.getBean("stdId");
        std.dispaly();
    }
}
