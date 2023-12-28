import classes.all.vishal;
import classes.all.laptop.vishals_laptop1;
import classes.all.laptop.vishals_laptop2;
import classes.all.phone.vishals_phone1;
import classes.all.phone.vishals_phone2;

public class use_packages {
    public static void main(String[] args) {
        vishal v = new vishal();
        v.method();

        vishals_laptop1 vl1 = new vishals_laptop1();
        vl1.method();
        vishals_laptop2 vl2 = new vishals_laptop2();
        vl2.method();
        vishals_phone1 vp1 = new vishals_phone1();
        vp1.method();
        vishals_phone2 vp2 = new vishals_phone2();
        vp2.method();
    }
}
