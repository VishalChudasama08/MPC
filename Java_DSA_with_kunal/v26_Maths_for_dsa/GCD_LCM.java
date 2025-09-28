package v26_Maths_for_dsa;

public class GCD_LCM {
    public static void main(String[] args) {
        // gcd: Greatest Common Divisor
        System.out.println("GCD: " + gcd(10, 15)); // biggest common number to divide both number

        System.out.println("LCD: " + lcd(10, 15));
    }
    static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }

    static int lcd(int a, int b){
        return a*b/gcd(a,b);
    }
}
