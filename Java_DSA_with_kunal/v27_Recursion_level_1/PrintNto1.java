package v27_Recursion_level_1;

public class PrintNto1 {
    public static void main(String[] args) {
        num(8);
        System.out.println("=======");
        numReverse(8);
        System.out.println("=======");
        numBoth(8);
    }
    static void num(int n){
        if(n>0){
//            num(n-1);
//            num(n--); // n-- not work on recursion, num(n--) means first pass n on argument than -1 from it,
                       // but in recursion this is going on infinite loop
            num(--n);
            System.out.println(n);
        }
    }
    static void numReverse(int n){
        if(n>0){
            System.out.println(n);
            numReverse(n-1);
        }
    }
    static void numBoth(int n){
        if(n>0){
            System.out.println(n);
            numBoth(n-1);
            System.out.println(n);
        }
    }
}
