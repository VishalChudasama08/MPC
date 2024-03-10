// multiple inheritance is not sported in java
// (ek rite... ) tethij interface no concept use thay chhe

// possible to use multiple interface in sigle class, but not allowed to use multiple abstract in single class

// defined interface
interface Bicycle { // jo interface no use kariye to temani badhij method no use karvo pade
    int a = 76; // aarite variable pan declare cari sakay pan te final chhe. tene modified na ri
                // sakay. khali use kari shakay. class object thi

    // aa methods ne public lakhoke na lakho kay farak pad to nathi, te by default public hoy chhe
    // pan te je class ma implements thase and use karvanu hoy tya public lakhavu pharajiyat chhe
    // aa interface ma jetli method banaviye tene jyare aa interface no use kariye tyare te badhij method no use karvo pade chhe

    void applyBrake(int decrement);
    private void ExtraBrake(){ // this private method use on default methods, see in j057 code file
        System.out.println("nothing...");
    }
    void speedUp(int increment);
}

interface HornBicycle { // another interface
    void blowHornK2g();

    void blowHornMehuna();
}

class AvonCycle implements Bicycle, HornBicycle { // aarite 1 this vadhare interface no use kari sakay pan abstract no
                                                  // use 1 thi vadhare karia sakato nay
    // interface use kar vu hoy tya extends (inheritance ni jem) keyword
    // no use thay chhe
    // ahi aa class ma interface implements karel chhe tethid interface ni badhij
    // method no use karvo padse

    public int a = 45;
    // interface na variable ne implements karela class ma override/modifiy kari sakay chhe, jyare object this nathi kari shakatu
    // pan te method ni jem jaruri nathi

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
