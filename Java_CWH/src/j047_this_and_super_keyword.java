class Base2{
    int p;
    public Base2(int p){
        this.p = p; // use this word to use this class variable, methods
    }

    public int getP() {
        return p;
    }
}
class Derived2 extends Base2{
    int a;
    Derived2(int a, int p){
        super(p); // use to call base class constructor with its arguments
        this.a = a;
    }

    public int getA() {
        return a;
    }
}
public class j047_this_and_super_keyword {
    public static void main(String[] args) {
        Derived2 d = new Derived2(1,2);
        System.out.println(d.getA());
        System.out.println(d.getP());
    }
}
