package javaconfiguration.setter.configuration;

import javaconfiguration.setter.beans.Address;
import javaconfiguration.setter.beans.Student;
import javaconfiguration.setter.beans.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavaConfiguration {
    @Bean
    public Address addressObj1(){
        Address addr = new Address();
        addr.setHouseNo(108);
        addr.setCity("Rajkot");
        addr.setPinCode(123456);
        return addr;
    }
    @Bean
    public Address addressObj2(){
        Address addr = new Address();
        addr.setHouseNo(208);
        addr.setCity("Ahmedabad");
        addr.setPinCode(123321);
        return addr;
    }
    @Bean
    public Subject subjectObj(){
        Subject sub = new Subject();
        List<String> sub_list = new ArrayList<>();
        sub_list.add("Java");
        sub_list.add("C++");
        sub_list.add("Python");
        sub.setSubjects(sub_list);
        return sub;
    }
    @Bean
    public Student studentObj(){
        Student std = new Student();
        std.setName("Vishal");
        std.setRollNumber(8);
//        std.setAddress(addressObj1()); // manually add dependency injection
        // add @Autowired annotation on this class this object

//        std.setSubject(subjectObj());
        return std;
    }
}
