// using java configuration file to make simple spring program

package spring02.program02.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring02.program02.pojoclass.Student;
import spring02.program02.resources.SpringConfigFile;

public class Main {
    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        // The ApplicationContext (Sprint Container) is an interface
        // in Spring which is used to manage beans, handle application events, and access resources

        // some implemented classes of ApplicationContext are:-
        // 1. (if used for XML file configuration then) ClassPathXmlApplicationContext
        // 2. (if used for java file configuration then) AnnotationConfigApplicationContext

        Student s1 = (Student) context.getBean("id1"); // (Student) it is typecast
        s1.display();

        System.out.println("=======================");

        Student s2 = (Student) context.getBean("bean2Name"); // change bean name in SpringConfigFile.java line=23
        s2.display();
    }
}
