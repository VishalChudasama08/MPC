package v20_cyclic_sort.Q442_FindAllDuplicatesInAnArray;
// solution by kunal (v20 1:12:12)
// Amazon question
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int [] arr = {};
        List<Integer> duplicateIS = findDuplicates(arr);
        System.out.println("duplicate Number is " + duplicateIS);
        System.out.println(Arrays.toString(arr));
    }
    public static List<Integer> findDuplicates(int[] nums) {
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

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                disappearedNumbers.add(nums[j]);
            }
        }
        return disappearedNumbers;
    }
}
