package v23_Rucursion;

public class Binary_Search_by_Recursion {
    public static void main(String[] args) {
        int[] arr = {1, 8, 45, 66, 88, 100, 150, 188};
        int target = 188;
        System.out.println(binarySearchByRecursion(arr, target, 0, arr.length - 1));
    }

    private static int binarySearchByRecursion(int[] arr, int target, int s, int e) {
        if (s > e) return -1;

        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        } else if(target < arr[m]){
            return binarySearchByRecursion(arr, target, s, m-1);
        } else {
            return binarySearchByRecursion(arr, target, m+1, e);
        }
    }
}
/*
    example for target 188
    Queue =>

    return binarySearchByRecursion(arr, target, 7, 7) m=6, m+1 = 6+1 = 7, this return 7 on privies function.
    return binarySearchByRecursion(arr, target, 6, 7) m=5, m+1 = 5+1 = 6, get return 7 from upper function and return 7 on itself privies function.
    return binarySearchByRecursion(arr, target, 4, 7) m=3, m+1 = 3+1 = 4, get return 7 from upper function and return 7 on itself privies function. main function
    return binarySearchByRecursion(arr, target, 0, 7) get return 7 from upper function and return 7 on main function
    main


        {1, 8, 45, 66, 88, 100, 150, 188} s=0, e=7
                        88, 100, 150, 188} s=4, e=7
                                  150, 188} s=6, e=7
                                        188} s=7, e=7, here if (arr[m] == target) is true and return m, return 7
 */
