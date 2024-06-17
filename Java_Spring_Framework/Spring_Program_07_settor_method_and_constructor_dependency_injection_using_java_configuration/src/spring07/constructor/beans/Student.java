package spring07.constructor.beans;

import spring07.setter.beans.Address;

public class Student {
    private String name;
    private int rollNumber;
    private Address address;
    public Student(String name, int rollNumber, Address address){ // using constructor add dependency injection
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
    }

    public Student(String vishal, int rollNumber, spring07.constructor.beans.Address address) {
    }

    public void display(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}
