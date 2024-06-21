package com.example.tabledata;

public class Student {

    private int std_roll_number;
    private String std_name;
    private float std_marks;
    
    public int getstd_roll_number() {
        return this.std_roll_number;
    }
    public String getstd_name() {
        return this.std_name;
    }
    public float getstd_marks() {
        return this.std_marks;
    }
    public void setstd_roll_number(int std_roll_number) {
        this.std_roll_number = std_roll_number;
    }
    public void setstd_name(String std_name) {
        this.std_name = std_name;
    }
    public void setstd_marks(float std_marks) {
        this.std_marks = std_marks;
    }
}