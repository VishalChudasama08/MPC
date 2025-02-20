package v20_cyclic_sort.Q448_FindAllNumbersDisappearedInAnArray;
// Google Question
// solution by kunal (v20 51:20)
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int [] arr = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);
        System.out.println(Arrays.toString(arr));
    }
    static List<Integer> findDisappearedNumbers(int [] nums) {
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
                disappearedNumbers.add(j+1);
            }
        }
        return disappearedNumbers;
    }
}
