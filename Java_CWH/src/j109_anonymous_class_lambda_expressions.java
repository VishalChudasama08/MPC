@FunctionalInterface
interface MyInterface2{
    public void method3(int a);
}
interface MyInterface1{
    public void method1();
    public void method2();
}
class DemoClass implements MyInterface1{
    public void method1(){
        System.out.println("I am method 1 in MyInterface1 implements DemoClass Class");
    }
    public void method2(){
        System.out.println("I am method 2 in MyInterface1 implements DemoClass Class");
    }
}
public class j109_anonymous_class_lambda_expressions {
    public static void main(String[] args) {
        // normally create a class object like this
        DemoClass d1 = new DemoClass();
        d1.method1();

        // polymorphism - interface to its implement class use to create an object
        MyInterface1 d2 = new DemoClass();
        d2.method1();

        // java anonymous class
        // if you create a class using interface but not use many time than create anonymous class and
        // write interface method block in here like this -->
        MyInterface1 d3 = new MyInterface1() { // without implements if use interface and override it all method than is anonymous
            @Override
            public void method1() {
                System.out.println("I am method 1 from MyInterface1 on anonymous class");
            }

            @Override
            public void method2() {
                System.out.println("I am method 2 from MyInterface1 on anonymous class");
            }
        }; // <-- not forget semicolon (;)
        d3.method1();

        // lambda expression - use only in @FunctionalInterface Interface
        MyInterface2 d4 = (a) -> { // write method block and a is argument
            System.out.println("I am method 3 from MyInterface2 in Lambda expression " + a);
        };
        d4.method3(8);
    }
}
