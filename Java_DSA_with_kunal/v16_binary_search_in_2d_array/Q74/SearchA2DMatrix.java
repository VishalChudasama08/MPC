package v16_binary_search_in_2d_array.Q74; // solution by vishal
// https://leetcode.com/problems/search-a-2d-matrix/description/

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int [] resultAt = binarySearchingIn2dArray(matrix, target);
        if(resultAt[0] == -1 && resultAt[1] == -1){
            return false;
        } else {
            return true;
        }
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
