package org.example.main;

import org.example.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String configuration = "org/example/configuration/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configuration);
        Student std = (Student) context.getBean(Student.class);
        std.dispaly();
    }
}