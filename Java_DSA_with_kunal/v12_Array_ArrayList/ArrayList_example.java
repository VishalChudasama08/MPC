package v12_Array_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_example {
    public static void main(String[] args) {
        // in normal array need to define how many length in initialise time,
        // but in ArrayList you not need to define time initialise array length, here not need to previously set to how many value store in array
        // also for in ArrayList value initialise and get provide methods

        Scanner in = new Scanner(System.in);
        
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            intList.add(in.nextInt());
        }
        System.out.println(intList);
        intList.remove(3);
        System.out.println(intList);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("This");
        strList.add("is");
        strList.add("String");
        strList.add("ArrayList");

        System.out.println(strList);
    }
}
