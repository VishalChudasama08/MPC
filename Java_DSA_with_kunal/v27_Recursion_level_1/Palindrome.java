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
        if(n%10 == n){ // if single digit number (-9 to 0 to 9) then ex. n=8 => 8%10=8
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digits-1)) + helper(n/10, digits-1);
        //  ex. 5214
        // last_number * 1000 + helper(remove_last_number, total_digit-1)
        // 4*1000 + helper(5214/10, 4-1)
        // 4*1000 + (1*100 + helper(521/10, 3-1))
        // 4*1000 + (1*100 + (2*10 + helper(52/10, 2-1))) // 52/10=5.2 integer => 5 run if (n%10 == n){return n;} n%10 => 5%10=5 => if (5 == 5){return 5;};
        // 4*1000 + (1*100 + (2*10 + (5)))
        // 4000 + 100 + 20 + 5
        // 4125
    }
}
