package v26_Maths_for_dsa;

public class DigitCount {
    public static void main(String[] args) {
        int n = 159463;
        int digit = (int)(Math.log10(n))+1;
        System.out.println(digit);
    }
}
