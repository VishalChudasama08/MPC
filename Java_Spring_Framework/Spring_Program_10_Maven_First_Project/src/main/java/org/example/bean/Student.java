package org.example.bean;

public class Student {
    private String name;
    private int rollNumber;
    private float mark;

    public void setName(String name) {
        this.name = name;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public void setMark(float mark) {
        this.mark = mark;
    }
    public void display(){
        System.out.println("Name : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Mark : " + mark);
    }
}
