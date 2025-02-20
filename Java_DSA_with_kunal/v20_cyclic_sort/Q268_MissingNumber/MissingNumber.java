package v20_cyclic_sort.Q268_MissingNumber;
// Amazon Question
// solution by kunal (v20 t34:44)
// ttps://leetcode.com/problems/missing-number/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        int [] arr = {3,0,1};
        int missingIs = missingNumber(arr);
        System.out.println("missing Number is " + missingIs);
        System.out.println(Arrays.toString(arr));
    }
    static int missingNumber(int [] nums) {
//        int i = 0;
//        while (i < nums.length) {
//            int correct = nums[i];
//            if (nums[i] < nums.length && nums[i] != nums[correct]){
//                int temp = nums[i];
//                nums[i] = nums[correct];
//                nums[correct] = temp;
//            } else {
//                i++;
//            }
//        }
//
//        int missingNumber = nums.length;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != j){
//                missingNumber = j;
//            }
//        }
//        return missingNumber;

        // best solution =>
        int n = nums.length;
        int sum = n*(n+1)/2;
        for (int i = 0; i < n; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}
