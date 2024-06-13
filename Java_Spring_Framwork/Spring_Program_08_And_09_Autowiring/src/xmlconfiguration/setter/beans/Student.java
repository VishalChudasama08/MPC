package xmlconfiguration.setter.beans;

import xmlconfiguration.setter.beans.Address;

public class Student {
    private String name;
    private int rollNumber;
    private xmlconfiguration.setter.beans.Address address;


    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void dispaly(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Address: " + address);
    }
}
