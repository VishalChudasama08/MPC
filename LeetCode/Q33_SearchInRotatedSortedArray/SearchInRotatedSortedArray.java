package Q33_SearchInRotatedSortedArray; // solution from java dsa by kunal v15
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
        int pivot = findPivot(nums);
        // if you not find pivot, it means the array is not rotated
        if(pivot == -1){
            // do simple binary search
            return binarySearch(nums, target, 0, nums.length-1);
        }
        // pivot index value is target value than
        if(nums[pivot] == target){
            return pivot;
        }
        // if pivot is found than you have 2 ascending order sorted array. separated by pivot
        // Then, apply binary search for this 2 array
        if(target >= nums[0]){
            // first array
            return binarySearch(nums,target,0,pivot-1);
        }
        // second array
        return binarySearch(nums, target, pivot + 1, nums.length-1);
    }

    // this will not work if duplicate values present in array (in this question all value is distinct values than working this method)
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
