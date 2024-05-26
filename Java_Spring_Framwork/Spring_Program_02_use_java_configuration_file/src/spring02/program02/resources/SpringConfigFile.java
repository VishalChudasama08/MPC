package spring02.program02.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring02.program02.pojoclass.Student;

@Configuration
public class SpringConfigFile {
// In XML-based Spring configuration, we use <bean> tags to define beans.
// In Java-based configuration, we use methods annotation with @bean to define beans.

// In XML configuration, we provide an "id" attribute to specify bean name, and we specify the "class" name using the class attribute.
// In Java configuration, the "Method name" becomes the default bean name, the "return type" of the method determines the class og the object that will create as the bean
    @Bean
    public Student id1(){ // ahi id1 e method nu name chhe, and Student e return type chhe, ahi Student class no object return thay chhe tethi Student class as return type lidhelu chhe
        // aa method ne bean method kahevay. jema set methods no use kari Student class ma value set thay.
        Student std1 = new Student();
        std1.setName("Vishal");
        std1.setRollNumber(108);
        std1.setEmail("vishal@com");
        return std1;
    }
    @Bean("bean2Name") // ("bean2Name") --> bean method and nicheni method na name sem chhe (ahi "id1" and "id2") jo tem na karvu hoy to
    public Student id2(){
        Student std2 = new Student();
        std2.setName("Darshan");
        std2.setRollNumber(28);
        std2.setEmail("darshan28@gmail");
        return std2;
    }
}
