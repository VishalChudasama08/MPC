package v15_binary_search_interview_question;

public class Floor { // Q-2 find the floor of a number (i (not in video) make as working in both ascending and descending order)
    // Binary Search working in only sorted array (increment or decrement)
    public static void main(String[] args) {
//        int [] arr = {-62,-42,-30,-22,-20,-18,-8,0,8,18,28,35,45,50,66,80,90}; // ascending array
        int [] arr = {88,76,70,66,52,45,37,28,18,2,0,-8,-10,-25,-36,-48,-55,-67,-76,-85}; // descending array

        int target = -77; // provide target value that not exist in array or between smaller & bigger value for find floor
        int presentAt = floorInArray(arr, target);
        if(presentAt != -1){
            System.out.println("Floor value of " + target + " is present at index: " + presentAt + " and that value is " + arr[presentAt]);
        } else {
            System.out.println("Floor value of " + target + " is not found in array");
        }
    }

    // in Math floor is than number this is like 5.55 -> 5, 8.12 -> 8 basically return that number
    // same as but here, floor in array: return the index of smalled no <= target.
    // target found than return that index, else return end index because at the end of loop end index is come at index than value is the biggest value but smaller than target and that is answered
    static int floorInArray(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        boolean orderAgnostic = arr[start]<arr[end];

        if (orderAgnostic){ // for ascending order
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
            return end; // return end index because at the end of loop end index is come at index than value is the biggest value but smaller than target and that is answered
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
            return start;
        }
    }
}
