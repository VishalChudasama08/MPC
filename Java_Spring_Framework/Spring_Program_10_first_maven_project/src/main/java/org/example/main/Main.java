package org.example.main;

import org.example.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Struct;

public class Main {
    public static void main(String[] args) {
        String configuration = "D://Happy_Coding//My_Code_In_Github//MPC//Java_Spring_Framework//Spring_Program_10_first_maven_project/src/main/java/org/example/configuration/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configuration);
        Student std = (Student) context.getBean(Student.class);
        std.dispaly();
    }
}