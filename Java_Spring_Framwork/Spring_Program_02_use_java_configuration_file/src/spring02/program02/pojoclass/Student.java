package spring02.program02.pojoclass; // pojoclass =~ java beans class
// pojoclass is simple class it is cover some variable and its getter, setter and display methods, also known as java beans class
public class Student {
    private String name;
    private String email;
    private int rollNumber;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getRollNumber() {return rollNumber;}
    public void setRollNumber(int rollNumber) {this.rollNumber = rollNumber;}
    public void display(){
        System.out.println("Name : " + this.name);
        System.out.println("Roll Number : " + this.rollNumber);
        System.out.println("Email : " + this.email);
    }
}
