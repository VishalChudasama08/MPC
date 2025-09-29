package Q1342_NumberOfStepsToReduceANumberToZero;
// solution by java dsa kunal v27 1:10:30
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
    static int numberOfSteps(int num) {
        return helper(num, 0);
    }
    static int helper(int num, int steps){
        if(num == 0){
            return steps;
        }
        if(num%2 == 0){
            return helper(num/2, steps+1);
        } else {
            return helper(num-1, steps+1);
        }
    }
}
