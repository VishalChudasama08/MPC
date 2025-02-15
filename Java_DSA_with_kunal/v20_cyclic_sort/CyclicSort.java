package v20_cyclic_sort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int [] arr = {9,1,8,2,7,3,4,6,5}; // 1,2,3,... N type array only, if any number is missing than not working ,
        // like as max number is 18 and min number is 8 than 8-18 all number is present in array than work else not work this method
        cyclic_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclic_sort(int [] arr) { // cyclic sort working on 1 to N type numeric array
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1; // value - 1 is correct index of that value
            if (arr[i] != arr[correct]){ // check value is correct position ? here arr[correct] == arr[i] means value is correct position else swap it
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
    }
}
