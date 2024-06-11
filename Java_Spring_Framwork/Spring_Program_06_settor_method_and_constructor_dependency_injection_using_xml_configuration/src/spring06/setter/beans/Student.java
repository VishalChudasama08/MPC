package spring06.setter.beans;

public class Student {
    private String name;
    private int rollNumber;
    private Address address;

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(Address address) {
        this.address = address;
    } // using setter method add dependency injection
    public void display(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}
