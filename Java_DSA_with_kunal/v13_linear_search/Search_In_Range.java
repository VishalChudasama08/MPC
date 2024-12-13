package v13_linear_search;

public class Search_In_Range {
    public static void main(String[] args) {
        int [] arr = {1,25,64,81,31,-12,42,-32,75,-55,88,2,100,35,65,15,-94,76,-27,29,92,43,61,-61,-49,38};

        int target = 88;
        int startAt = 5;
        int endAt = 18;
        int presentAt = searchInRange(arr, target, startAt, endAt);

        if(presentAt != -1 ) System.out.println("value '" + target + "' is present at index: " + presentAt );
        else System.out.println("value '" + target + "' is not found.");
    }

    static int searchInRange(int [] arr, int target, int startAt, int endAt){
        if(arr.length == 0) return -1;

        for (int i = startAt; i <= endAt ; i++) {
            if (arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
