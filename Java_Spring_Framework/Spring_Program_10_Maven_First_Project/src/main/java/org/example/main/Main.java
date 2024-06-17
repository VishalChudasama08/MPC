package org.example.main;

import org.example.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/configuration/applicationContext.xml");
        Student std = (Student) context.getBean("stdId");
        std.display();
        // settings --> Build, Execution, Deployment --> Build Tools --> click on "Maven" --> find -> "maven home path :" and choose -> "C:/Maven/apache-maven-3.9.8"
        // project structure setting --> module --> find "module SDK" and choose : oracle jdk-21 it on c:/program file/java
        // project structure setting --> SDKs --> choose 21
    }
}
