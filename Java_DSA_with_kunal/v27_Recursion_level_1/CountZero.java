package v27_Recursion_level_1;

public class CountZero {
    public static void main(String[] args) {
        System.out.println(countZero(1020304));
    }
    static int countZero(int n){
        return helper(n,0);
    }
    static int helper(int n, int z){
        if(n == 0){
            return z;
        }
        int rem = n%10;
        if(rem == 0){ // replace 0 with your value which you can find
            return helper(n/10, z+1);
        } else {
            return helper(n / 10, z);
        }
    }
}
