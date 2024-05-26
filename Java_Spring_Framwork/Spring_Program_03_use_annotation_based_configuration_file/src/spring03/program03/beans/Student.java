package spring03.program03.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // ahi @Component annotation spring beans object banav se
public class Student { // object nu name capital later ma na hoy etle, "Student" mathi object na name ma "student" thay jase
    @Value("Vishal") // used @Value annotation in spring to inject values into spring beans field or method
    private String name;
    @Value("vishal08@gmail.com")
    private String email;
    @Value("08")
    private int rollNumber;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getRollNumber() {return rollNumber;}
    public void setRollNumber(int rollNumber) {this.rollNumber = rollNumber;}
    public void display(){
        System.out.println("Name : " + this.name);
        System.out.println("Roll Number : " + this.rollNumber);
        System.out.println("Email : " + this.email);
    }
}
