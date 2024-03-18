abstract class Shape1 { //ahi class ma method abstract karel chhe tethi class abstract thay/karvo pade
    double height, width;

    Shape1(double width, double height) {
        this.height = height;
        this.width = width;
    }

    abstract double area(); // use abstract to override method using another class,
    // jo method abstract banavvi hoy to te class ne pan abstract banav vo pade,
    // abstract class no object na banavi sakay, te class no use inheritance karinej karisakay
    // je class ma inherit karel hot te class ma abstract method ne override karvi pade (abstract method no use karvo pade),
    // jo method ne override na kariye to te class (jema abstract class inherit karel hoy ) ne pan abstract class banavvo pade
}

class Rectangle3 extends Shape1 {
    Rectangle3(double w, double h) {
        super(w, h);
    }

    @Override
    double area() { // override abstract class abstract method, and use it
        return (width * height);
    }
}

class Triangle extends Shape1 {
    Triangle(double base, double height) {
        super(base, height);
    }

    double area() {
        return (0.5 * height * width);
    }
}

public class j053_abstract_class_and_method {
    public static void main(String[] args) {
        Rectangle3 r = new Rectangle3(10, 15);
        System.out.println("Area of Rectangle : " + r.area());

        Triangle t = new Triangle(20, 15);
        System.out.println("Area of Triangle : " + t.area());
    }
}
