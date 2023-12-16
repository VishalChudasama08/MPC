class Employee1{
    float salary;
    String name;
    public float getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
}
class Phone{
    public void ringing(){
        System.out.println("ringing...");
    }
    public void vibrate(){
        System.out.println("vibrate...");
    }
    public void callFriend(){
        System.out.println("calling Friend...");
    }
}
class Square{
    float side;
    public float area(){
        return side*side;
    }
    public float perimeter(){
        return 4*side;
    }
}
class Rectangle{
    float width, length;
    public float area(){
        return width*length;
    }
    public float perimeter(){
        return 2*(width+length);
    }
}
class Andy{
    public void hit(){
        System.out.println("Andy Hitting the enemy");
    }
    public void run(){
        System.out.println("Andy Running from the enemy");
    }
    public void fire(){
        System.out.println("Andy Firing on the enemy");
    }
}
class Circle{
    double radius;
    public double area(){
        return 3.14*radius*radius;
    }
    public double perimeter(){
        return 2*3.14*radius;
    }
}
public class j039_practice_set_8 {
    public static void main(String[] args) {
        //Q-1
        Employee1 v = new Employee1();
        v.setName("Other");
        v.salary = 500000;
        System.out.println(v.getName());
        System.out.println(v.getSalary());
        System.out.println();

        //Q-2
        Phone realme6 = new Phone();
        realme6.callFriend();
        realme6.vibrate();
        realme6.ringing();

        //Q-3
        Square sq = new Square();
        sq.side = 3;
        System.out.println(sq.area());
        System.out.println(sq.perimeter());
        System.out.println();

        //Q-4
        Rectangle rt = new Rectangle();
        rt.width = 3;
        rt.length = 5;
        System.out.println(rt.area());
        System.out.println(rt.perimeter());
        System.out.println();

        //Q-5
        Andy p1 = new Andy();
        p1.hit();
        p1.fire();
        p1.run();

        //Q-6
        Circle ci = new Circle();
        ci.radius = 3;
        System.out.println(ci.area());
        System.out.println(ci.perimeter());
        System.out.println();
    }
}
