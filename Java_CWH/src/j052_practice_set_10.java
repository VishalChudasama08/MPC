class Circle1{
    public int radius;
    public Circle1(){
        System.out.println("I am Circle class non parameterized constructor");
    }
    public Circle1(int radius) {
        System.out.println("I am Circle class parameterized constructor");
        this.radius = radius;
    }
    public double area(){
        return Math.PI*this.radius*this.radius;
    }
}
class Cylinder1 extends Circle1{
    public int height;
    Cylinder1(int r, int h){
        super(r); // if you use super key word with parameters than call, super class (Circle1) parameterized constructor
                  // else run non parameterized constructor
        System.out.println("I am Cylinder1 parameterized constructor");
        this.height = h;
    }
    public double volume(){
        return Math.PI*this.radius*this.radius*height;
    }
}

class Shape {
    double height, width;
    public Shape(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
class Rectangle2 extends Shape{
    public double length;

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    Rectangle2(double r, double h){
        super(r, h);
    }
    public double area(){
        return width*height;
    }
    public double volume(){
        return length*height*width;
    }
}
class Base3{
    public Base3() {
        System.out.println("I am Base3 class Constructor");
    }
}
class Derived3 extends Base3{
    public Derived3() {
        System.out.println("I am Derived3 class Constructor");
    }
}
class Derived4 extends Derived3{
    public Derived4() {
        System.out.println("I am Derived4 class constructor");
    }
}
public class j052_practice_set_10 {
    public static void main(String[] args) {
        // Q-1
        Cylinder1 cy = new Cylinder1(4, 10);

        // Q-2
        Rectangle2 rt = new Rectangle2(22,10);

        // Q-3
        System.out.println("Area of Circle1 is : " + cy.area());
        System.out.println("Volume of Cylinder1 is : " + cy.volume());
        System.out.println();

        // Q-4
        rt.setLength(12);
        System.out.println("Rectangle length is " + rt.getLength());
        System.out.println("Rectangle width is " + rt.getWidth());
        System.out.println("Rectangle height is " + rt.getHeight());
        System.out.println("Rectangle area is " + rt.area());
        System.out.println("Rectangle volume is " + rt.volume());
        System.out.println();

        // Q-5
        Derived4 de = new Derived4();
        //calling first Base3 class constructor than Derived3 class constructor than Derived4 class constructor
    }
}
