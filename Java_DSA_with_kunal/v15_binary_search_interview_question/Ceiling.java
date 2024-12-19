package v15_binary_search_interview_question;

public class Ceiling { // Q-1 Find than ceiling number (i (not in video) make as working in both ascending and descending order)
    // Binary Search working in only sorted array (increment or decrement)
    public static void main(String[] args) {
//        int [] arr = {-62,-42,-30,-22,-20,-18,-8,0,8,18,28,35,45,50,66,80,90}; // ascending array
        int [] arr = {88,76,70,66,52,45,37,28,18,2,0,-8,-10,-25,-36,-48,-55,-67,-76,-85}; // descending array

        int target = 19; // provide target value that not exist in array or between smaller & bigger value for find ceiling
        int presentAt = ceiling(arr, target);
        if(presentAt != -1){
            System.out.println("Ceiling value of " + target + " is present at index: " + presentAt + " and that value is " + arr[presentAt]);
        } else {
            System.out.println("Ceiling value of " + target + " is not found in array");
        }
    }

    // in Math ceiling is than number this is like 5.55 -> 6.00, 8.12 -> 9 basically return bigger number
    // same as but here, Ceiling in array: return the index of smalled no >= target.
    // target found than return that index, else return start index because at the end of loop start index is come at index than value is smallest but bigger than target and that is answered
    static int ceiling(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        boolean orderAgnostic = arr[start]<arr[end];

        if (orderAgnostic){ // for ascending order
            // if the target is greater than the greatest number of array than means ceiling is not possible
            if (arr[end] < target) {
                return -1;
            }
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
            return start; // return start value(variable value) for ascending order because at the end of loop start value(variable value) is come at index than value(array value) is smallest but bigger than target and that is answered
        } else { // for descending order
            // if target is greater than the greatest number of array than means ceiling is not possible
            if (arr[start] < target) {
                return -1;
            }
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
            return end;
        }
    }
}
