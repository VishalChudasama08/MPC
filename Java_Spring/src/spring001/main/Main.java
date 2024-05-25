package spring001.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring001.pojo_class.student;

public class Main {
    public static void main(String[] args) {
        String config_lac = "/spring001/configuration/applicationContext.xml"; // save xml (spring configuration
                                                                               // metadata) file location
        ApplicationContext context = new ClassPathXmlApplicationContext(config_lac); // aa context xml file ma aapela
                                                                                     // class no object banavse,
        // ahi xml file ma <bean> tag na class attribute value ma je class
        // (student.java) chhe te class no id attribute ni value (id) na name no Object
        // banavse

        student std1 = (student) context.getBean("id1"); // "id" --> <bean> tag ni je id hot te
        std1.display();
        student std2 = (student) context.getBean("id2"); // "id" --> <bean> tag ni je id hot te
        std2.display();
    }
}
