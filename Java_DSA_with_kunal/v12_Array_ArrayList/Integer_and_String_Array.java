package v12_Array_ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Integer_and_String_Array {
    public static void main(String[] args) {
        // in java arrays object not continuously stored in heap. but in another language like c,c++ array value continuously stored
        // because in java not pointer concept exist
        // in java int[] arr = {1,2,3}; than in heap arr[0] this is variable than value is 1, same as arr[1] value is 2,... that variable in heap memory stored any ware
        // for batter understanding view video number 12 at 25:00 mint

        Scanner in = new Scanner(System.in);

        int [] arr1; // define integer array
        int [] arr2 = new int[5]; // define and initialise with length of integer array
        int [] arr3 = {1,2,3,4,5,6,7,8,9}; // define and initialise with array value

        String [] arr4;
        String [] arr5 = new String[3];
        String [] arr6 = {"This", "is", "string",  "array"};

        System.out.println(arr2[1]); // try to access empty primitive datatype (int, float, dabble, long) array that => 0
        System.out.println(arr2[3]); // 0

        System.out.println(arr5[1]); // try to access empty non-primitive datatype (String, char) array that => null
        System.out.println(arr5[2]); // null

        System.out.print("Enter 5 integer value: ");
        // initialise arr2 value
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = in.nextInt();
        }
        // accessing array value
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2 index " + i + " value is " + arr2[i]);
        }
        // accessing all array value by method
        System.out.println(Arrays.toString(arr2));
        System.out.print("arr3 value is: ");
        // access all array value by foreach loop
        for (int one:arr3) {
            System.out.print(one + " ");
        }
        System.out.println();

        System.out.print("Enter 3 String value: ");
        // initialise arr2 value
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = in.next();
        }
        // accessing array value
        for (int i = 0; i < arr5.length; i++) {
            System.out.println("arr5 index " + i + " value is " + arr5[i]);
        }
        // accessing all array value by method
        System.out.println(Arrays.toString(arr5));
        System.out.print("arr6 value: ");
        // access all array value by foreach loop
        for (String str:arr6) {
            System.out.print(str + " ");
        }
    }
}
