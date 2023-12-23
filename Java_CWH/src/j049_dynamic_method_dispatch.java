class Laptop{
    public void method1(){
        System.out.println("I am Laptop, a laptop include display, keyboard, touchpad, motherboard, spacer, camera, battery,...");
    }
    public void method2(){
        System.out.println("motherboard present on laptop.");
    }
}

class MotherBoard extends Laptop {
    public void method2(){
        System.out.println("Motherboard use to make laptop");
    }

    public void method3(){
        System.out.println("In Motherboard include ram,rom,processor, capacitor, graphic-card and many more");
    }
}
public class j049_dynamic_method_dispatch {
    public static void main(String[] args) {
        // Laptop l = new Laptop(); // Allowed
        // MotherBoard m = new MotherBoard(); // Allowed

        Laptop lm = new MotherBoard(); // Allowed
        // this is dynamic method dispatch, use derived class to create base class object,
        // but not allowed to use base class to create derived class object

        // MotherBoard ml = new Laptop(); // Not Allowed

        // using dynamic method dispatch created object to call only base class method,
        // but method overriding case this object (in this program lm object) call on derived class method not calling on base class method

        lm.method1(); // Allowed, call on base class method. possible to call all base class method. not call only overriding method (in this program base class method2)
        lm.method2(); // Allowed, call on derived class method
        // lm.method3(); // Not Allowed, on derived class allowed only overriding method, not allowed another all method
    }
}
