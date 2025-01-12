package v15_binary_search_interview_question.Q33; // solution from java dsa by kunal v15
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSortedArray {
    // sorted rotated array ->
    // [4,5,6,7,0,1,2] -> [2,4,5,6,7,0,1] -> [1,2,4,5,6,7,0] -> [0,1,2,4,5,6,7] -> [7,0,1,2,4,5,6]

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,8,1,2,3};
        int target = 5;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int lastIndex = nums.length - 1;
        if(nums[0] == target) return 0;
        if(nums[lastIndex] == target) return lastIndex;
        int peakValueIndex = findPeakElement(nums);
        System.out.println(peakValueIndex);
        // Try to find the target in the ascending part
        int answer = binarySearch(nums, target,0,peakValueIndex);
        if(answer != -1){
            System.out.println("on not descending");
            return answer;
        } else {
            System.out.println("on descending"+ peakValueIndex);
            // Try to find the target in the descending part
            return binarySearch(nums, target, peakValueIndex + 1, nums.length - 1);
        }
    }
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid+1]){ // true it means we are in decreasing part of array
                end = mid;
            } else { // else we are in increasing part of array or possible this is max value
                start = mid + 1;
            }
        } // loop ending this time start = end
        return start; // return and start or end because both at sem position
    }

    public static int binarySearch(int [] arr, int target, int start, int end){
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
