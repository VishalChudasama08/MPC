package v15_binary_search_interview_question; // solution from java dsa by kunal v15

public class FindPositionElementSortedArrayInfiniteNumbers {
    public static void main(String[] args) {
        int [] arr = {3,5,7,9,10,90,100,130,140,160,170}; // imagine this is infinite array
        int target = 10;
        System.out.println(ans(arr,target));
    }
    static int ans(int[] arr, int target){
        // first start with a box or range 2 than multiplying range
        int start = 0;
        int end = 1;

        while (target > arr[end]){
            int temp = end + 1; // newStart
            // multiplying rage OR double box rage value
            // formula => new = previous end + sizeOfBox * 2
            end = end + (end - start + 1)*2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int [] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;
            if (target < arr[mid]) {
                end = mid-1;
            } else if (target > arr[mid]){
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
