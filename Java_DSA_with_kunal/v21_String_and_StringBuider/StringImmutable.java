package v21_String_and_StringBuider;

import java.util.Arrays;
import java.util.Locale;

public class StringImmutable {
    public static void main(String[] args) {
        String a = "Vishal";
        String b = "Vishal";
        // that both store in heep memory and here a and b target same value in heep not two "Vishal" store, only one "Vishal" store

        System.out.println(a == b);
        System.out.println(a.equals(b));

        String a1 = new String("Vishal");
        String b1 = new String("Vishal");
        // that not store in heep memory.

        System.out.println(a1 == b1); // false
        System.out.println(a1.equals(b1)); // true
        // for this reason string comparing use equals()

        System.out.println(a.length()); // return integer string length. this is method than use bracket -> ()

        String a2 = a.concat(" Chudasama"); // hare a not change, this method return new String
        System.out.println(a2); // (here we print that new return string)

        int a3 = a.indexOf("V");
        System.out.println(a3); //

        char a4 = a.charAt(1);
        System.out.println(a4);

        String[] a5 = a2.split(" "); // split return array
        System.out.println(Arrays.toString(a5));

        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());
        System.out.println(a.lastIndexOf(""));
    }
}
