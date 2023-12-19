class Cylinder{
    private int height,radius;

    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    //generate and getter and setter => goto -> code (in navigation top line) -> generate -> getter and setter -> then select variable name you wan to generate get and set method
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double surfaceArea(){
        // V = 2πr² + 2πrh (area of cylinder)
        return (2*Math.PI*radius*radius) + (2*Math.PI*radius*height);
    }

    public double volume(){
        //volume of cylinder is πr²h
        return Math.PI*radius*radius*height;
    }
}

class Rectangle1{
    private int length, breath;

    public Rectangle1() {
        this.length = 4;
        this.breath = 5;
    }

    public Rectangle1(int length, int breath) {
        this.length = length;
        this.breath = breath;
    }

    public int getLength() {
        return length;
    }

    public int getBreath() {
        return breath;
    }
}

class Sphere {
    private int radius;

    public Sphere(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double surfaceArea(){
        // A=4πr² (area of sphere)
        return 4*Math.PI*radius*radius;
    }

    public double volume(){
        //volume of cylinder is V=4/3πrr²
        return ((double) 4 /3)*Math.PI*radius*radius*radius;
    }
}
public class j044_practice_set_9 {
    public static void main(String[] args) {
        //Q-1
        //Q-3
        Cylinder cy = new Cylinder(8, 12);
        cy.setHeight(12);
        System.out.println("Cylinder Height is : " + cy.getHeight());
        cy.setRadius(8);
        System.out.println("Cylinder Radius is : " + cy.getRadius());

        //Q-2
        System.out.println("Surface Area of Cylinder is : " + cy.surfaceArea());
        System.out.println("Volume of Cylinder is : " + cy.volume());

        //Q-3
        //solved on Q-1

        //Q-4
//        Rectangle1 rac = new Rectangle1();
        Rectangle1 rac = new Rectangle1(6, 8);
        System.out.println("Rectangle Length is : " + rac.getLength());
        System.out.println("Rectangle Breath is : " + rac.getBreath());

        //Q-5
        Sphere s = new Sphere(8);
        System.out.println("Sphere Radius is " + s.getRadius());
        System.out.println("Sphere Surface Area is : " + s.surfaceArea());
        System.out.println("Sphere volume is : " + s.volume());
    }
}
