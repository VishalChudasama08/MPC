package spring001.pojo_class;

public class student {
    private String name;
    private int rollNo;
    private String email;

    public String getName() {
        return name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void display(){
        System.out.println("Name : " + name);
        System.out.println("RollNo : " + rollNo);
        System.out.println("Email : " + email );
    }
}
