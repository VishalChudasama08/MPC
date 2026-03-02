package v29_Merge_Sort_Using_Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    public static int [] mergeSort(int [] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // .copyOfRange method return one copy of array by sending stating to ending index
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    // merge two sorted array
    public static int [] merge(int [] first, int [] second){
        int [] merged = new int[first.length + second.length];
        int i=0;
        int j=0;
        int k=0;

        while(first.length > i && second.length > j){
            if(first[i] < second[j]){
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }
        // add remaining elements (possible wen both part is not same length)
        while (first.length > i){
            merged[k]=first[i];
            i++;
            k++;
        }
        while(second.length > j){
            merged[k]=second[j];
            j++;
            k++;
        }

        return merged;
    }
}
