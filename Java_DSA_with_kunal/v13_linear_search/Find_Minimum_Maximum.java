package v13_linear_search;

public class Find_Minimum_Maximum {
    public static void main(String[] args) {
        int [] arr = {1,25,64,81,31,-12,42,-32,75,-55,88,2,100,35,65,15,-94,76,-27,29,92,43,61,-61,-49,38};

        int minimum = findMinimum(arr);

        if(minimum != -1 ) System.out.println("Minimum value is '" + minimum + "'");
        else System.out.println("Minimum value not found. because provided array is empty");

        int maximum = findMaximum(arr);

        if(maximum != -1 ) System.out.println("Maximum value is '" + maximum + "'");
        else System.out.println("Maximum value not found. because provided array is empty");


    }
    static int findMinimum(int [] arr){
        if (arr.length == 0) return -1;
        int min = arr[0];
        for (int element: arr) {
            if (element < min) min = element;
        }
        return min;
    }

    static int findMaximum(int [] arr){
        if (arr.length == 0) return -1;
        int max = arr[0];
        for (int element: arr) {
            if (element > max) max = element;
        }
        return max;
    }
}
