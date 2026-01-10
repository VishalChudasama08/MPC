package v28_Recursion_Array_Questions;
// v27 kunal 28:00, 43:00
import java.util.ArrayList;

public class FindAllIndex {
    public static void main(String[] args) {
        int [] arr = {8,5,6,7,8,8,9,10};
        findAllIndex(arr, 8, 0);
        System.out.println(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(findAllIndexAndReturnList(arr, 8, 0, list2));
    }
    static ArrayList<Integer> list1 = new ArrayList<>(); // create global array list so not need to return on findAllIndex method
    static void findAllIndex(int [] arr, int target, int index){
        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            list1.add(index);
        }
        findAllIndex(arr, target, index+1);
    }

    static ArrayList<Integer> findAllIndexAndReturnList(int [] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndexAndReturnList(arr, target, index+1, list);
    }
}
