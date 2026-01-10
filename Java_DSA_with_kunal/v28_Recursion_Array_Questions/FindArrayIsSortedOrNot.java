package v28_Recursion_Array_Questions;
// v27 kunal 17:31

public class FindArrayIsSortedOrNot {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println(sorted(arr, 0));
    }
    public static boolean sorted(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }
}
