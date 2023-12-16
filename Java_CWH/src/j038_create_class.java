//on java 1 file 1 public class only, if you write more public class than it is error
class Employee{
    int id;
    String name;
    public void Employee_details(){
        System.out.println("Id is " + id);
        System.out.println("Name is " + name);
    }
}
public class j038_create_class {
    public static void main(String[] args) {
        Employee vishal = new Employee(); // Instantiating a new Employee Object

        //Set Attributes values
        vishal.id = 8;
        vishal.name = "Vishal";
        vishal.Employee_details(); // method calling

        Employee y = new Employee(); // Instantiating a new Employee Object
        y.id = 10;
        y.name = "Yellow";
        y.Employee_details();
    }
}
