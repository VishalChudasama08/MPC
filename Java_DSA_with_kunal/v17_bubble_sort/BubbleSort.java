package v17_bubble_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {5,-18,76,-8,4,1,0};
        bubble_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubble_sort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped){ // swapped is true, then array not sort, swapped is false then array sorted
                break;
            }
        }
    }
}
