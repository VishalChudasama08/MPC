package v19_insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {5,-18,76,-8,4,1,0};
        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion_sort(int [] arr){ // best sorting method for parcel sorted or small arrays (array not full sorted but same part of array is sorted that is parcel sorted array)
        for (int i = 0; i < arr.length-1; i++) {
            for (int j =  i + 1; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    swapped(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void swapped(int [] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
