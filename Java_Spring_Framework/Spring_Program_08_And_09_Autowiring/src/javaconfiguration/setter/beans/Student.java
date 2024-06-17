package javaconfiguration.setter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
    private String name;
    private int rollNumber;
    @Autowired // The @Autowited annotation in Spring is used for automatic dependency injection.
    @Qualifier("addressObj2") // used to defined Address class which bean object use, if present many object than use this annotation
    private Address address;
    @Autowired
    private Subject subject;

    /*
    Advantage of Autowiring annotation
    -> It requires less code

    Disadvantage of Autowiring annotation
    -> it can be achived only on non-primitive or user-defined data types (excluding String)
    -> not on primitive data type (Boolean, char, byte, int, short, float and double)
     */

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public void dispaly(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Subjects: " + subject);
    }
}
