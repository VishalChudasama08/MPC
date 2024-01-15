// if you make in the future, not add method and only present one method in the interface this is called FunctionalInterface annotation
@FunctionalInterface
interface MyInterface {
    void method1();
}

class OneClass{
    public void oneMethod(){
        System.out.println("I am OneClass oneMethod");
    }
}

class TwoClass extends OneClass {
    @Override // if method is override than use override annotation
    public void oneMethod(){
        System.out.println("I am Override TwoClass oneMethod");
    }
    @Deprecated // if you not use this method than make defined @Deprecated
    public int sum(int a, int b){ // if you use this method than showing warning
        return a+b;
    }
}
public class j108_annotation {
    // @SuppressWarnings("deprecation") // in this method you use any deprecated method than write this to run perfectly
    public static void main(String[] args) {
        TwoClass t = new TwoClass();
        t.oneMethod();
        System.out.println(t.sum(10, 20));
    }
}