package v13_linear_search;

public class Linear_Search {
    // best to use Linear Search for unsorted array
    // working sorted arrays but this is not recommended to use Linear Search methods for sorted arrays because time complexity
    public static void main(String[] args) {
        int [] arr = {1,25,64,81,31,-12,42,-32,75,-55,88,2,100,35,65,15,-94,76,-27,29,92,43,61,-61,-49,38};

        int target = 88;
        int presentAt = linearSearch1(arr, target);

        if(presentAt != -1 ) System.out.println("value '" + target + "' is present at index: " + presentAt );
        else System.out.println("value '" + target + "' is not found.");

        boolean found = linearSearch2(arr, target);
        if (found) System.out.println("value '" + target + "' is present in array.");
        else System.out.println("value '" + target + "' is not found.");
    }
    // return index value
    static int linearSearch1(int [] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    static boolean linearSearch2(int [] arr, int target){
        if(arr.length == 0){
            return false;
        }
        for (int element:arr) {
            if (element == target){
                return true;
            }
        }
        return false;
    }
}
