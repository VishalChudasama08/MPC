package v28_Recursion_Array_Questions;
// by kunal v28 1:16:00
public class RotatedArrayBinarySearch {
    public static void main(String[] args) {
	// find in rotated array using binary search and recursion
        int[] arr = {5,6,7,8,9,1,2,3};
        System.out.println(rbs(arr,2,0,arr.length-1));
    }
    public static int rbs(int[] arr, int target, int s, int e){
        if (s>e){
            return -1;
        }

        int m = s+(e-s)/2;

        if(arr[m]==target){
            return m;
        }

        // here, array is rotated then any one part is sorted.
        // case-1 (1.1 assume first part is sorted)
        if(arr[s]<=arr[m]){
            // case-1 (1.2 check first part sorted?)
            if(target>=arr[s] && target<=arr[m]){
                return rbs(arr, target, s, m-1);
            } else {
                return rbs(arr, target, m+1, e);
            }
        }
        // case-2 (second part is sorted ?)
        if(target>=arr[m] && target<=arr[e]){
            return rbs(arr, target, m+1, e);
        }
        // case-3 (array is in sorted)
        return rbs(arr, target, s, m-1);
    }
}
