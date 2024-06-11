package javaconfiguration.constructor.configuration;

import javaconfiguration.constructor.beans.Address;
import javaconfiguration.constructor.beans.Student;
import javaconfiguration.constructor.beans.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavaConfiguration {
    @Bean
    public Address addressObj1(){
        Address addr = new Address(108, "Rajkot", 123456);
        return addr;
    }
    @Bean
    public Address addressObj2(){
        Address addr = new Address(208, "Ahmedabad", 123321);
        return addr;
    }
    @Bean
    public Subject subjectObj() {
        List<String> sub_list = new ArrayList<>();
        sub_list.add("Java");
        sub_list.add("C++");
        sub_list.add("Python");
        return new Subject(sub_list);
    }
    @Bean
    public Student studentObj(){
        Student std = new Student("Vishal", 8);
        // not need to manually add dependency injection in constructor arguments
        // add @Autowired annotation on this class this object (Student class, this declaration time)
        return std;
    }
}
