class Base{
    public int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class Derived extends Base { // using extends keyword to inheritance Base class on derived class
    public int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class j045_inheritance {
    public static void main(String[] args) {
        // Creating an Object of base class
        Base b =new Base();
        b.setX(4);
        System.out.println(b.getX());

        // Creating an object of derived class
        Derived d = new Derived();
        d.setY(45);
        System.out.println(d.getX());
    }
}
