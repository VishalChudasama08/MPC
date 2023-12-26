interface BaseInterface{
    void method1();
    void method2();
}
interface DerivedInterface extends BaseInterface{ // interface inheritance sem as class inheritance
    void method3();
    void method4();
}

class SimpleClass implements DerivedInterface{
    public void method1(){
        System.out.println("I am method1");
    }
    public void method2(){
        System.out.println("I am method2");
    }
    public void method3(){
        System.out.println("I am method3");
    }
    public void method4(){
        System.out.println("I am method4");
    }
}
public class j058_inheritance_in_interface {
    public static void main(String[] args) {
        SimpleClass sc = new SimpleClass();
        sc.method1();
        sc.method2();
        sc.method3();
        sc.method4();
    }
}
