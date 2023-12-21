class A{
    public void method(){
        System.out.println("I am Method of class A");
    }
}
class B extends A{
    @Override // use @Override to show this method is overriding, it is optional but recommended
    public void method(){ // sem name method but in inheritance, then it is method overriding
        System.out.println("I am Method of class B");
    }
}
public class j048_method_overriding {
    public static void main(String[] args) {
        A a = new A();
        a.method();

        B b = new B();
        b.method(); // call this b class method only, not a class
    }
}
