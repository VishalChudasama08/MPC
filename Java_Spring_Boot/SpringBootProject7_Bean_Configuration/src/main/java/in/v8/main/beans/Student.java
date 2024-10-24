package in.v8.main.beans;

public class Student {
	private String name;
	private int rollNumber;
	private float marks;
	
	public Student(String name, int rollNum, float mark) {
		this.name = name;
		this.rollNumber = rollNum;
		this.marks = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public void printDetails() {
		System.out.println("Name: " + name + "\nRoll Number: " + rollNumber + "\nMarks: " + marks);
	}
}
