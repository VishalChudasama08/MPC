package v27_Recursion_level_1;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(123454321));
    }
    static boolean palindrome(int number){
        return (number == reverseDigit(number));
    }
    static int reverseDigit(int n) {
        int digitCount = (int)(Math.log10(n))+1;
        return helper(n, digitCount);
    }
    static int helper(int n, int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digits-1)) + helper(n/10, digits-1);
        //  ex. 1214
        // last_number * 1000 + helper(remove_last_number, total_digit-1)
        // 4*1000 + helper(1234/10, 4-1)
        // 4*1000 + (1*100 + helper(121/10, 3-1))
        // 4*1000 + (1*100 + (2*10 + helper(12/10, 2-1)))
        // 4*1000 + (1*100 + (2*10 + (1*1 + helper(1/10, 1-1))))
        // 4*1000 + (1*100 + (2*10 + (1*1 + (0.1)))) // 0.1 to integer => 0
        // 4*1000 + (1*100 + (2*10 + (1*1 + 0)))
        // 4000 + 100 + 20 + 1
        // 4121
    }
}
