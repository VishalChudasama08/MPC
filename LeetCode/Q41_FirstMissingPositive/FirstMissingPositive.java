package Q41_FirstMissingPositive;
// https://leetcode.com/problems/first-missing-positive/description/
// solution by kunal (v20 1:31:52)
import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        int MissingPositive = firstMissingPositive(arr);
        System.out.println(MissingPositive);
        System.out.println(Arrays.toString(arr));
    }
    static int firstMissingPositive(int [] nums){
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1){
                return j + 1;
            }
        }

        return nums.length + 1;
    }
}
