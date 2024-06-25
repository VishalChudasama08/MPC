package org.example.bean;

public class Student {
    private String name;
    private int rollNumber;
    private float marks;

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }


    public void dispaly(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("marks: " + marks);
    }
}
