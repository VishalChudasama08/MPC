//Q-1
abstract class Pen{
    abstract void write();
    abstract void refill();
}
//Q-2
class FountainPen extends Pen {
    void write(){
        System.out.println("Wrote");
    }
    void refill(){
        System.out.println("Refill");
    }
    void changeNib(){
        System.out.println("Changing the nib");
    }
}

//Q-3
interface BasicAnimal{
    void eat();
    void sleep();
}
class Monkey{
    void jump(){
        System.out.println("Jumping...");
    }
    void bite(){
        System.out.println("Biting...");
    }
}
class Human extends Monkey implements BasicAnimal{
    void speak(){
        System.out.println("Hello Guys!");
    }
    public void eat(){
        System.out.println("Eating...");
    }
    public void sleep(){
        System.out.println("Sleeping...");
    }
}

//Q-4
abstract class TelePhone{
    abstract void ring();
    abstract void lift();
    abstract void disconect();
}
class SmartTelePhone extends TelePhone{
    void ring(){
        System.out.println("Ringing...");
    }
    void lift(){
        System.out.println("Lifting...");
    }
    void disconect(){
        System.out.println("Disconnected...");
    }
    void saveNumber(){
        System.out.println("Save Number...");
    }
}

//Q-6
interface TVRemote{
    void volume();
    void changechanals();
}

interface SmartTVRemote{
    void play_netflix();
    void play_disney();
}

//Q-7
class TV implements TVRemote, SmartTVRemote{
    public void volume(){
        System.out.println("Use to Volume Up and Down");
    }
    public void changechanals(){
        System.out.println("Change chanel");
    }
    public void play_netflix(){
        System.out.println("Play Netflix");
    }
    public void play_disney(){
        System.out.println("Play Disney");
    }
}
public class j060_practise_set_11_abstract_and_interface {
    public static void main(String[] args) {
        //Q-1
        //creating abstract class

        //Q-2
        // create class to extend abstract class
        FountainPen pen = new FountainPen();
        pen.changeNib();

        //Q-3
        Human vishal = new Human();
        vishal.sleep();
        vishal.eat();
        vishal.speak();
        vishal.jump();

        //Q-4
        TelePhone tp = new SmartTelePhone();
        tp.ring();
        tp.lift();
        tp.disconect();
        // tp.savenumber(); //not allowed because TelePhone abstract class does not have savenumber methods

        //Q-5
        Monkey m = new Human();
        m.bite();
        m.jump();
        // m.speak(); // not allowed // monkey class does not have speak method

        BasicAnimal ba = new Human();
        ba.eat();
        ba.sleep();
        // ba.speak(); // not allowed because BasicAnimal class does not have speak method

        //Q-6
        // create interface TVRemote and SmartTVRemote

        //Q-7
        TV tv = new TV();
        tv.volume();
        tv.changechanals();
    }
}
