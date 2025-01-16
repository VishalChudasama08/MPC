package v15_binary_search_interview_question.Q410; // solution from java dsa by kunal v15
// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int [] arr = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(arr,k));
    }
    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of loop start have max number from nums
            end += nums[i]; // sum all number
        }
        while (start < end){
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for (int num: nums) {
                if (sum + num > mid){
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if(pieces > k){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
