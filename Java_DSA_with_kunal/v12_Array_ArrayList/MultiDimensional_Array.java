package v12_Array_ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensional_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int [][] arr = new int[3][]; // row length provide is compulsory
        int [][] arr2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; // define and initialise, here this is [4][3] 4 row and 3 column as per all row

        int [][] arr1 = new int[3][2]; // here for provide (initialise array) value to need to define all dimension length here 3 row and 2 column
        System.out.print("Enter integer value for arr1 [3][2] = 6 integer: ");
        for (int row = 0; row < arr1.length; row++) {
            for (int column = 0; column < arr1[row].length; column++) {
                arr1[row][column] = in.nextInt();
            }
        }
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.print("3D array: ");
        int [][][] arr3 = new int[3][][];
        int [][][] arr4 = {  // [4][3][2]
            {
                {1,2},
                {3,4},
                {5,6}
            },
            {
                {7,8},
                {9,10},
                {11,12}
            },
            {
                {13,14},
                {15,16},
                {17,18}
            },
            {
                {19,20},
                {21,22},
                {23,24}
            }
        };
        System.out.println(Arrays.deepToString(arr4));


        System.out.println("\n String 2D array");
        String[][] arr5 = new String[2][];
        String[][] arr6 = new String[2][2];
        System.out.print("Enter String value for arr6 [2][2] = 4 word: ");
        for (int row = 0; row < arr6.length; row++) {
            for (int column = 0; column < arr6[row].length; column++) {
                arr6[row][column] = in.next();
            }
        }
        for (int row = 0; row < arr6.length; row++) {
            for (int column = 0; column < arr6[row].length; column++) {
                System.out.print(arr6[row][column] + " ");
            }
            System.out.println();
        }

        String[][] arr7 = {
            {"row0-column0","row0-column1"},
            {"row1-column0","row1-column1"}
        };
        System.out.println(Arrays.deepToString(arr7));

    }
}
