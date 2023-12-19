class MyEmployee{
    private int p;
    private String name;
    public void setId(int n){
        p = n; //set values
    }
    public void setName(String n){
        name = n; //set values
    }
    public int getId(){
        return p; //get values
    }
    public String getName(){
        return name; //get values
    }
}
public class j040_access_modifiers {
    public static void main(String[] args) {
        MyEmployee vishal = new MyEmployee();
        vishal.setId(8); //set values
        vishal.setName("Vishal"); //set values
        System.out.println("Employee Name is " + vishal.getName()); //get values
        System.out.println("Employee ID is " + vishal.getId()); //get values
    }
}
