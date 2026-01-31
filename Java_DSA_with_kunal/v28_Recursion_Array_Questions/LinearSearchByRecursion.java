package v28_Recursion_Array_Questions;
// v28 kunal 25:00 || 26:00
public class LinearSearchByRecursion {
    public static void main(String[] args) {
        int [] arr = {4,3,6,7,2,8,9};
        System.out.println(linearSearch(arr, 5, arr.length-1));
        System.out.println(linearSearchFindIndex(arr, 8, arr.length-1));
    }

    public static boolean linearSearch(int [] arr, int target, int index) {
        if(index == -1){
            return false;
        }
        return arr[index] == target || linearSearch(arr, target, index-1);
    }
    public static int linearSearchFindIndex(int [] arr, int target, int index) {
        if(index == -1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        } else {
            return linearSearchFindIndex(arr, target, index-1);
        }
    }
}
