class Employee2{
    private int id;
    private String name;
    public Employee2(){
        id = 7;
        name = "Kalpesh";
    }
    public Employee2(int n, String str){
        id = n;
        name = str;
    }
    public int getId(){
        return id; //get values
    }
    public String getName(){
        return name; //get values
    }
}
public class j042_constructors_and_overlod {
    public static void main(String[] args) {
//        Employee2 k = new Employee2(); //Constructor called
        Employee2 v = new Employee2(8, "Vishal"); //constructor called with arguments
        System.out.println(v.getId());
        System.out.println(v.getName());
    }
}
