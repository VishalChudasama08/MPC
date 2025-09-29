package v27_Recursion_level_1;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNum(74613));
    }
    static int reverseNum(int n){
        return reverseDigit(n, countDigit(n));
//        int rev=0;
//        int rem;
//        while (n>0){
//            rem = n%10;
//            rev = (rev*10) + rem;
//            n /= 10;
//        }
//        return rev;
    }
    static int reverseDigit(int n, int d){
        if(d > 0){
            return (n%10 * d) + reverseDigit(n/10, d/10);
        }
        return 0;
    }
    static int countDigit(int n){
        int ten = 1;
        while(n>0){
            ten *= 10;
            n /= 10;
        }
        return ten/10;
    }
}
