package v15_binary_search_interview_question.Q1095; // solution from java dsa by kunal v15
// https://leetcode.com/problems/find-in-mountain-array/description/

public class FindInMountainArray {
    public static void main(String[] args) {
        int [] nums = {0,1,2,4,2,1};
        int target = 3;
        System.out.println(findInMountainArray(target,nums));
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
    public static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end, boolean isAscending){
        if (isAscending){ // for ascending order
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
        } else { // for descending order
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    return mid;
                }
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
    }
    public static int findInMountainArray(int target, int [] mountainArr) {
        int peakValueIndex = findPeakElement(mountainArr);
        // Try to find the target in the ascending part
        int answer = orderAgnosticBinarySearch(mountainArr, target,0,peakValueIndex, true);
        if(answer != -1){
            System.out.println("on not descending");
            return answer;
        } else {
            // Try to find the target in the descending part
            System.out.println("on descending");
            return orderAgnosticBinarySearch(mountainArr, target, peakValueIndex + 1, mountainArr.length - 1, false);
        }
    }

//    solution code =>
//interface MountainArray {
//    public int get(int index) {}
//    public int length() {}
//}
//public static int findPeakElement(MountainArray mountainArr) {
//    int start = 0;
//    int end = mountainArr.length() - 1;
//
//    while (start < end){
//        int mid = start + (end - start) / 2;
//        if(mountainArr.get(mid) > (mountainArr.get(mid+1))){ // true it means we are in decreasing part of array
//            end = mid;
//        } else { // else we are in increasing part of array or possible this is max value
//            start = mid + 1;
//        }
//    } // loop ending this time start = end
//    return start; // return and start or end because both at sem position
//}
//    public static int orderAgnosticBinarySearch(MountainArray mountainArr, int target, int start, int end, boolean isAscending){
//
//        if (isAscending){ // for ascending order
//            while (start <= end) {
//                int mid = (start + end) / 2;
//                if (mountainArr.get(mid) == target) {
//                    return mid;
//                }
//                if (mountainArr.get(mid) > target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//            return -1;
//            while (start <= end) {
//                int mid = (start + end) / 2;
//                if (mountainArr.get(mid) == target) {
//                    return mid;
//                }
//                if (mountainArr.get(mid) < target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//            return -1;
//        }
//    }
//    public static int findInMountainArray(int target, MountainArray mountainArr) {
//        int peakValueIndex = findPeakElement(mountainArr);
//        // Try to find the target in the ascending part
//        int answer = orderAgnosticBinarySearch(mountainArr,target,0,peakValueIndex, true);
//        if(answer != -1){
//            return answer;
//        } else {
//            // Try to find the target in the descending part
//            return orderAgnosticBinarySearch(mountainArr, target, peakValueIndex + 1, mountainArr.length() - 1, false);
//        }
//    }
}
