package v11;

import java.util.Arrays;

public class valueChange {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("a = " + a);
        changeInteger(a);
        System.out.println("a = " + a); // value not changing

        int[] arr = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(arr));
        changeIntegerArray(arr);
        System.out.println(Arrays.toString(arr)); // yes value changing

        String b = "Vishal";
        System.out.println(b);
        changeString(b);
        System.out.println(b); // value not changing

        String[] c = { "Vishal", "Darshan", "Piyush" };
        System.out.println(Arrays.toString(c));
        changeStringArray(c);
        System.out.println(Arrays.toString(c)); // yes value changing

        Boolean e = true;
        System.out.println(e);
        changeBoolean(e);
        System.out.println(e); // value not changing

        Boolean[] g = { true, true, false, false };
        System.out.println(Arrays.toString(g));
        changeBooleanArray(g);
        System.out.println(Arrays.toString(g)); // yes value changing
    }

    static void changeInteger(int b) {
        b = 20;
    }

    static void changeIntegerArray(int[] array) {
        array[0] = 0;
    }

    static void changeString(String newB) {
        newB = "NotVishal";
    }

    static void changeStringArray(String[] d) {
        d[0] = "Nitin";
    }

    static void changeBoolean(Boolean f) {
        f = false;
    }

    static void changeBooleanArray(Boolean[] h) {
        h[0] = false;
    }
}
