package Q34_FindFirstAndLastPositionOfElementInSortedArray; // solution from java dsa by kunal v15

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int [] arr = {};
        int target = 9;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int [] ans = {-1, -1};

        ans[0] = searching(nums, target, true); // find first index
        if (ans[0] != -1) { // ans[0] return -1 means target is not found than not need for find last index
            ans[1] = searching(nums, target, false); // find last index
        }

        return ans;
    }
    // this function just return the index value of target
    static  int searching(int [] nums, int target, boolean findFirstIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (nums[mid]>target){
                end = mid-1;
            } else if (nums[mid]<target){
                start = mid+1;
            } else {
                ans = mid;
                if(findFirstIndex){ // first index finding got it, but possible another first index is present... like case -> {5,7,7,7,7,8,9} target = 7 than ,here mid = 3rd 7 but first index is 1 for target
                    end = mid - 1;
                } else {
                    start = mid + 1; // for find last index
                }
            }
        }
        return ans;
    }
}
