package javaconfiguration.constructor.beans;

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

    public Student(String name, int rollNumber){
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public void dispaly(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Subjects: " + subject);
    }
}
