package v20_cyclic_sort.Q268_MissingNumber;
// Amazon Question
// solution by vishal (kunal solution is different v20 t34:44)
//

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int [] arr = {3,0,1};
        int missingIs = missingNumber(arr);
        System.out.println("missing Number is " + missingIs);
        System.out.println(Arrays.toString(arr));
    }
    static int missingNumber(int [] nums) { // not all time full array sorting, this method at the end put arrays max value at missing number place. that place index is missing number
        int i = 0;
        int length = nums.length;
        int maxValueIndex = length;
        while (i < length) {
            int correct = nums[i];
            if (correct == length){
                i++;
                continue;
            }
            if (nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                if(nums[i] == length){
                    maxValueIndex = i;
                }
            } else {
                i++;
            }
        }
        return maxValueIndex;
    }
}
