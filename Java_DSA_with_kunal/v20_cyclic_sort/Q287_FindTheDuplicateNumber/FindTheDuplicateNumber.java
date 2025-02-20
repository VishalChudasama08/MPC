package v20_cyclic_sort.Q287_FindTheDuplicateNumber;

import java.util.Arrays;

// Amazon Question
// solution by vishal & kunal (v20 t1:03:00)
// https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int [] arr = {3,1,1,4,2};
        int duplicateIS = duplicateNumber(arr);
        System.out.println("duplicate Number is " + duplicateIS);
        System.out.println(Arrays.toString(arr));
    }
    static int duplicateNumber(int [] nums) {
        // kinal solution =>
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] != i+1){ // for sorting number is not at it's correct space than true
                int correct = nums[i] - 1;
                if (nums[i] != nums[correct]){ // if condition is false that means this value duplicate, also as index 'i' and 'correct' is same
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;

        // my solution =>
//        int i = 0;
//        int n = nums.length;
//        while (i < n) {
//            int correct = nums[i] - 1;
//            if (nums[i] != nums[correct]){
//                int temp = nums[i];
//                nums[i] = nums[correct];
//                nums[correct] = temp;
//            } else {
//                i++;
//            }
//        }
//        int duplicateNumberId = nums[n-1];
//        for (int j = 0; j < n; j++) {
//            if (nums[j] != j+1){
//                duplicateNumberId = nums[j];
//            }
//        }
//        return duplicateNumberId;
    }
}
