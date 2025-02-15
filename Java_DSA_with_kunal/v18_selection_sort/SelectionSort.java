package v18_selection_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {5,-18,76,-8,4,1,0};
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selection_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, last);
            swapped(arr, maxIndex, last);
        }
    }
    static int getMaxIndex(int[] arr, int last){
        int maxValueIndex = 0;
        for (int i = 1; i <= last ; i++) {
            if(arr[maxValueIndex] < arr[i]){
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }

    static void swapped(int [] arr, int maxIndex, int lastIndex){
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }
}
