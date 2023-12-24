// possible to use multiple interface in sigle class, but not allowed to use multiple abstract in single class

// defined interface
interface Bicycle { // jo interface no use kariye to meni badhij method no use karvo pade
    int a = 76; // aarite ariable pan declare cariasakay pan te final chhe. tene modified nari
                // sakay khali use kariashakay class object thi

    void applyBrake(int decrement);

    void speedUp(int increment);
}

interface HornBicycle { // another interface
    void blowHornK2g();

    void blowHornMehuna();
}

class AvonCycle implements Bicycle, HornBicycle { // aarite 1 this vadhare interface no use kari sakay pan abstract no
                                                  // use 1 thi vadhare nathis karia sakato
    // interface use kar vu hoy tya extends (inheritance) ni jem implement keyword
    // no use thay chhe
    // ahi aa class ma interface implements karel chhe tethid interface ni badhij
    // method no use karvo padse

    void blowHorn() {
        System.out.println("Pee Pee Poo Poo ☺");
    }

    public void applyBrake(int decrement) { // interface in method ne public rakhavipde
        System.out.println("Applying Brake");
    }

    public void speedUp(int increment) {
        System.out.println("Applying SpeedUP");
    }

    public void blowHornK2g() {
        System.out.println("Kabhi khushi kabhi gum pee pee pee pee");
    }

    public void blowHornMehuna() {
        System.out.println("Main hoon nna po po po po");
    }
}

public class j055_interface_vs_abstract_class {
    public static void main(String[] args) {
        AvonCycle VishalBycycle = new AvonCycle();
        System.out.println("interface class Final variable value is " + VishalBycycle.a); // allowed
        // VishalBycycle.a = 454; // Not allowed to modify it

        VishalBycycle.blowHornK2g();
        VishalBycycle.blowHornMehuna();
    }
}
