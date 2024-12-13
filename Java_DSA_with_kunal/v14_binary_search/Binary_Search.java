package v14_binary_search;

public class Binary_Search {
    // Binary Search working in only sorted array (increment or decrement)
    public static void main(String[] args) {
//        int [] arr = {-62,-42,-30,-22,-20,-18,-8,0,8,18,28,35,45,50,66,80,90};
        int [] arr = {88,76,70,66,52,45,37,28,18,2,0,-8,-10,-25,-36,-48,-55,-67,-76,-85};

        int target = 88;
        int presentAt = binary_Search(arr, target);
        if(presentAt != -1){
            System.out.println("value " + target + " is present at index: " + presentAt );
        } else {
            System.out.println("value " + target + " is not found.");
        }
    }

    static int binary_Search(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        boolean orderAgnostic = arr[start]<arr[end];

        while (start <= end){
            int mid = (start + end) / 2;
            if (arr[mid] == target){
                return mid;
            }
            if (orderAgnostic){
                if(arr[mid] > target){
                    end = mid - 1;
                } else {
                    start = mid+1;
                }
            } else {
                if(arr[mid] < target){
                    end = mid - 1;
                } else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
