package v25_Bitwise_operstors_number_systems;

public class Get_nthBitByUsingBitwiseOperators {
    public static void main(String[] args) {
        long n = 10110110;
        long l = 1010110110;
        System.out.println("7th bit of " + n + " is " + getNthBit(n,8));
        System.out.println("7th bit of " + l + " is " + getNthBit(l,8));
    }
    private static long getNthBit(long n, int v){
        long bit;
        bit = 1 & (n >> v);
        return bit;
    }
}
