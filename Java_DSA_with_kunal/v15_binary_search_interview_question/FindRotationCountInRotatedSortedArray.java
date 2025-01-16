package v15_binary_search_interview_question; // solution from java dsa by kunal v15

import java.util.List;

// Question -> find rotation count in rotated sorted array
// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class FindRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {7, 9, 11, 12, 5}; // {4,5,6,7,1,2}
        System.out.println(findKRotation(arr));
    }
    public static int findKRotation(int [] arr) {
        return findPivot(arr) + 1;
    }

    // find pivot for non-duplicate value array
    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // find pivot in array that contents Duplicate values
    public static int findPivotForDuplicateValues(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            // if elements of start, middle, end are equal than skip the duplicates
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                // first cheak that start and end element is pivot ?
                if(start+1 != arr.length && arr[start] > arr[start+1]){ // start+1 != arr.length this condition for indexOutOfBound exception
                    return start;
                }
                if(end-1 != -1 && arr[end] < arr[end-1]){ // end-1 != -1 this condition for indexOutOfBound exception
                    return end-1;
                }

                // skipping deprecation
                start++;
                end--;
            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
