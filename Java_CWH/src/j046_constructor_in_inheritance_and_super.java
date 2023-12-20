class Base1{
    public Base1(){
        System.out.println("I am a Base class constructor");
    }
    public Base1(int x) {
        System.out.println("I am an overloaded of Base class With value of x is : " + x);
    }
}
class Derived1 extends Base1 {
    public Derived1(){
        System.out.println("I am a Derived class constructor");
    }
    public Derived1(int x, int y){
        super(x); // super keyword call base class constructor with it argument
        System.out.println("I am an overloaded of Derived class With value of y is : " + y);
    }
}
class ChildOfDerived extends Derived1{
    public ChildOfDerived(){
        System.out.println("I am a ChildOfDerived class constructor");
    }
    public ChildOfDerived(int x, int y, int z){
        super(x,y); // super keyword call its base class constructor with its arguments
        System.out.println("I am an overloaded of ChildOfDerived class With value of z is : " + z);
    }
}
public class j046_constructor_in_inheritance_and_super {
    public static void main(String[] args) {
        // Base1 b = new Base1(); // this line call only Base1 class constructor
        // Base1 b = new Base1(1); // this line call overloaded constructor
        // Derived1 d = new Derived1(); // this line call first Base1 class constructor than call its constructor
        // Derived1 d = new Derived1(1, 2); // this line call first its overloaded constructor, but super keyword call Base1 class overloaded constructor (with its 1 argument, x) and, than run its constructor block next lines...
        // ChildOfDerived cd = new ChildOfDerived(); // this line call first Base1 class constructor than call Derived1 class constructor than call its constructor
        ChildOfDerived cd = new ChildOfDerived(1, 2, 3); // this line call first its overloaded constructor, but super keyword call Derived1 class overloaded constructor (with its 2 argument, x and y), but this Derived1 class overloaded constructor super keyword call Base1 class overloaded constructor (with its 1 argument, x) and run this, than run Derived1 class overloaded constructor block next lines... and last run ChildOfDerived Class overloaded constructor block lines...
    }
}
