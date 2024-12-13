package v13_linear_search;

import java.util.Arrays;

public class Search_In_2D_Array {
    public static void main(String[] args) {
        int [][] arr = {
            {1, 25, 64, 81, 31},
            {-12, 42, -32, 75},
            {-55, 88, 2},
            {100, 35, 65, 15, -94, 76},
            {-27,29,92,43,61,-61,-49,38}
        };

        int target = 881;
        int [] presentAt = searchingIn2DArray(arr, target);

        if(presentAt.length != 0 ) System.out.println("value '" + target + "' is present at index: " + Arrays.toString(presentAt));
        else System.out.println("value '" + target + "' is not found.");
    }
    static int[] searchingIn2DArray(int[][] arr, int target){
        if (arr.length == 0) return new int[0]; // return empty array
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (arr[row][column] == target) return new int[]{row, column};
            }
        }
        return new int[0]; // return empty array
    }

}
