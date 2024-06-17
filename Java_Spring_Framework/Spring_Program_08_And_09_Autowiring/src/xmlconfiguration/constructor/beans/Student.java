package xmlconfiguration.constructor.beans;

import xmlconfiguration.constructor.beans.Address;

public class Student {
    private String name;
    private int rollNumber;
    private xmlconfiguration.constructor.beans.Address address;

    public Student(String name, int rollNumber, Address address) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.address = address;
    }
    public void dispaly(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Address: " + address);
    }
}
