package v15_binary_search_interview_question.Q162; // solution from java dsa by kunal v15

public class FindPeakElement {
    public static void main(String[] args) {
        int [] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
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
}
