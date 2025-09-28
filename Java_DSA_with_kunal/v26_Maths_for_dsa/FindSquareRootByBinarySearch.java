package v26_Maths_for_dsa;

public class FindSquareRootByBinarySearch {
    public static void main(String[] args) {
        int n = 35465;
        int p = 3; // how many number after point. ex: 6.324

        System.out.printf("\n%.3f",squareRoot(n,p));
    }
    static double squareRoot(int n, int p){

        // find square root by simple binary search
        // work only for perfect square root integer number. if answer in pointing number than not work
        int start = 0;
        int end = n;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid*mid == n) { // ex. 2*2 = 4 => square root of 4 is 2
                return mid;
            } else if(mid*mid > n){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        // not found by binary search means square root is in pointing value now find it
        double squareRoot = 0.0;
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while(squareRoot*squareRoot < n){
                squareRoot += increment;
//                System.out.printf(" %.3f", squareRoot);
            }
            squareRoot -= increment;
            increment /= 10; // 0.1 => 0.01, 0.01=>0.001
        }

        return squareRoot;
    }
}
