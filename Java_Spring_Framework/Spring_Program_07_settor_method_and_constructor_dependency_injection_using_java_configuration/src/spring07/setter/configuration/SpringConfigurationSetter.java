package spring07.setter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring07.setter.beans.Address;
import spring07.setter.beans.Student;

@Configuration  // aa anotaion no use kar vathis spring container ne khabar pade ke aa file ma aa class ma spring ni configuration provide karel chhe
public class SpringConfigurationSetter {
    @Bean
    public Address returnAddrObj(){ // create method to return object
        Address addr = new Address();
        addr.setHouseNo(108);
        addr.setCity("Rajkot");
        addr.setPinCode(360002);
        return addr;
    }
    @Bean
    public Student returnStdObj(){
        Student std = new Student();
        std.setName("Vishal");
        std.setRollNumber(8);
        std.setAddress(returnAddrObj());
        return std;
    }
}
