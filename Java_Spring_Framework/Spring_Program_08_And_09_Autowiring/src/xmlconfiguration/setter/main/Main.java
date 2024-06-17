package xmlconfiguration.setter.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlconfiguration.setter.beans.Student;

public class Main {
    public static void main(String [] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("xmlconfiguration/setter/configuration/applicationContext.xml");
        Student std = (Student) context.getBean("stdId");
        std.dispaly();
    }
}
