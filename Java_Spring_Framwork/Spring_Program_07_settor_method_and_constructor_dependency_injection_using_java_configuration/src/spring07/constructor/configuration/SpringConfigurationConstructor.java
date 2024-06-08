package spring07.constructor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring07.constructor.beans.Address;
import spring07.constructor.beans.Student;

@Configuration
public class SpringConfigurationConstructor {
    @Bean
    public Address returnsAddrObj(){
        Address addr = new Address(108, "Rajkot", 360002);
        return addr;
    }
    public Student returnsStdObj(){
        Student std = new Student("Vishal", 8, returnsAddrObj());
        return std;
    }
}
