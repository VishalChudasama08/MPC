package v15_binary_search_interview_question.Q852; // solution from java dsa by kunal v15
// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int [] arr = {1,3,5,8,11,18,16,12,9,7,4,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]){ // true it means we are in decreasing part of array
                end = mid;
            } else { // else we are in increasing part of array or possible this is max value
                start = mid + 1;
            }
        } // loop ending this time start = end
        return start; // return and start or end because both at sem position
    }
}
