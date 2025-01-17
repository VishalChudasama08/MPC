package v16_binary_search_in_2d_array;

import java.util.Arrays;

public class SearchingInMatrix {
    public static void main(String[] args) {
        int [][] arr = {
            {10, 20, 30, 40, 50},
            {12, 22, 32, 42, 52},
            {14, 24, 34, 44, 54},
            {16, 26, 36, 46, 56},
            {18, 28, 38, 48, 58},
        };
        int target = 18;

        System.out.println(Arrays.toString(searchingInMatrix(arr, target)));
    }
    public static int[] searchingInMatrix(int[][] matrix, int target){
        int row = 0;
        int column = matrix[0].length - 1; // it's return max column number if find max row than -> row = matrix.length - 1

        while (row < matrix.length && column >= 0){
            if(matrix[row][column] == target){
                return new int[]{row, column};
            }
            if(matrix[row][column] < target){
                row++;
            } else {
                column--;
            }
        }
        return new int[]{-1,-1};
    }
}
