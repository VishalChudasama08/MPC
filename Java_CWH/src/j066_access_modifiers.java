import java.lang.reflect.Modifier;

class only{
    public int a = 1;
    protected int b = 2;
    int c = 3;
    private int d = 4;
    public void method(){
        System.out.println("public : " + a);
        System.out.println("protected : " + b);
        System.out.println("default : " + c);
        System.out.println("private : " + d);
    }
}
public class j066_access_modifiers {
    public static void main(String[] args) {
        only v = new only();
        v.method();
        /*
         * Modifier     Class   Package     SubClass    World
         * Public         Y        Y           Y          Y
         * Protected      Y        Y           Y          N
         * Default (no)   Y        Y           N          N
         * Private        Y        N           N          N
         *
         * Class   => other Class on sem file
         * Package => using package to use class than
         * Default => sub class like inheritance and abstract class
         * world   => another folder
         */
    }
}
