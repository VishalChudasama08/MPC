package v27_Recursion_level_1;

public class SumOfNumber {
    public static void main(String[] args) {
        System.out.println("Digit sum: "+digitSum(2646));
        System.out.println("======================");
        System.out.println("Digit multiply: "+prod(3215)); // digit multiply
    }
    static int digitSum(int n){
        if(n>0){
            return n%10 + digitSum(n/10);
        } else {
            return 0; // only for remove error, this not run aver
        }
    }
    static int prod(int n){
        if(n>0){
            return n%10 * digitSum(n/10);
        } else {
            return 0; // only for remove error, this not run aver
        }
    }
}
