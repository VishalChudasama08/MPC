package v16_binary_search_in_2d_array;

import java.util.Arrays;

public class SearchingInSorted2dArray {
    public static void main(String[] args) {
        int [][] arr = {
            {1,   2,  3,  4,  5,  6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37 ,38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
            {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
            {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
            {91, 92 ,93 ,94, 95, 96 ,97, 98, 99, 100}
        };
        System.out.println(Arrays.toString(binarySearchingIn2dArray(arr, 101)));
    }
    public static int [] binarySearchingIn2dArray(int [][] matrix, int target){
        int rows = matrix.length;
        int columns = matrix[0].length;
//        System.out.println(rows + " " + columns);

        // if only one row exist than
        if(rows == 1){ // means 2d array but only one row than, ex. {{1, 2, 3, 4, 5}}
            return binarySearch(matrix, 0, 0, columns-1, target);
        }

        int sRow = 0;
        int eRow = rows - 1;
        while (sRow < eRow){ // at thi end this loop return sRow != eRow than 2 rows, else than return 1 rows and target is present in that rows
            if (sRow == eRow - 1){
                break;
            }
            int rMid = sRow + (eRow - sRow)/2;
            if(matrix[rMid][0] == target){
                return new int[]{rMid, 0};
            }
            if (matrix[rMid][0] < target){
                sRow = rMid; // not -1 because possible to target is present in this row (rMid) in another column
            } else {
                eRow = rMid - 1;
            }
        }

//        System.out.println(sRow + " " + eRow);
        if (matrix[sRow][columns-1] == target){
            return new int[]{sRow, columns-1};
        }
        if (matrix[sRow][columns-1] < target){
            return binarySearch(matrix, eRow,0,columns-1,target);
        } else {
            return binarySearch(matrix,sRow,0,columns-2,target);
        }
    }

    // searching in 1 provided row only, (here binary search in like normal array not 2d array)
    // cMid -> column mid, cStart -> column start, cEnd -> column end
    public static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while (cStart <= cEnd){
            int cMid = cStart + (cEnd - cStart)/2;
            if (matrix[row][cMid] == target){
                return new int[]{row, cMid};
            }
            if(matrix[row][cMid] < target){
                cStart = cMid + 1;
            } else {
                cEnd = cMid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}