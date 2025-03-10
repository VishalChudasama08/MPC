package Q645_SetMismatch;
// https://leetcode.com/problems/set-mismatch/description/
// solution by kunal (v20 1:21:00)

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int [] arr = {6,4,2,7,5,8,2,1};
        int[] errorNumber = findErrorNums(arr);
        System.out.println(errorNumber);
        System.out.println(Arrays.toString(arr));
    }
    static int[] findErrorNums(int [] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                return new int[] {nums[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }
}
