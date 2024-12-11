package v12_Array_ArrayList;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MultiDimensional_ArrayList_example {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // define

        // initialise
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        System.out.println("Enter 9 integer: ");
        // add element
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(in.nextInt());
            }
        }
        System.out.println(list);

        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>(); // define

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(25);list3.add(15);list3.add(35);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(22);list4.add(12);list4.add(32);

        list2.add(list3);
        System.out.println(list2);
        list2.add(list4);
        System.out.println(list2);


        System.out.println("String 2D ArrayList");
        ArrayList<ArrayList<String>> listOfString = new ArrayList<>();

        ArrayList<String> innerList1 = new ArrayList<>();
        innerList1.add("row0-column0");
        innerList1.add("row0-column1");

        // Add the first inner ArrayList to the outer ArrayList
        listOfString.add(innerList1);

        ArrayList<String> innerList2 = new ArrayList<>();
        innerList2.add("row1-column0");
        innerList2.add("row1-column1");

        // Add the second inner ArrayList to the outer ArrayList
        listOfString.add(innerList2);

        // Print the entire structure
        System.out.println(listOfString);
    }
}
