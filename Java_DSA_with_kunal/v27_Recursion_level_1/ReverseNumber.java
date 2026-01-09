package v27_Recursion_level_1;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNum(74613));
    }
    static int reverseNum(int n){
        return reverseDigit(n, powerOfTen(n));
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

        // ex: n=4321, d=1000
        // return (n%10 * d) + reverseDigit(n/10, d/10);
        // return (1*1000) + reverseDigit(432, 100); // 4321/10=432.1=432, 1000/10=100
        // return (1*1000) + (2*100) + reverseDigit(43, 10);
        // return (1*1000) + (2*100) + (3*10) + reverseDigit(4, 1);
        // return (1*1000) + (2*100) + (3*10) + (4*1) + reverseDigit(0, 0); // 4/10=0.4=0, 1/10=0.1=0
        // return 1000 + 200 + 30 + 4;
        // return 1234;
    }
    static int powerOfTen(int n){
        int ten = 1;
        while(n>0){
            ten *= 10;
            n /= 10;
        }
        return ten/10;
    }
}
