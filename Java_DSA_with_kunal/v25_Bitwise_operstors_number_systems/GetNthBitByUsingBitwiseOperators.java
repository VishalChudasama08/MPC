package v25_Bitwise_operstors_number_systems;

public class GetNthBitByUsingBitwiseOperators {
    public static void main(String[] args) {
        int n = 8; // 1000 = 8 here, 3rd bit is 0
        int l = 15; // 1111 = 15 here, 3rd bit is 1
        int bit = 3;
        System.out.println(bit +"th bit of " + n + " is " + getNthBit(n,bit-1)); // if get 5th bit then v = 4.
        // by right shift remove 4 bit now 5th bit is first position. use & (AND) operator with 1 this return first position bit
        // if 5th bit is 0 then 0 & 1 = 0 if 5th bit is 1 then 1 & 1 = 1 means return 5th bit only.
        System.out.println(bit+"th bit of " + l + " is " + getNthBit(l,bit-1)); // here 5th bit is
    }
    private static int getNthBit(int n, int v){
        int bit;
        bit = (n >> v) & 1; // bitwise operator work in bit. you sent decimal, but it converts binary then work in it
        return bit;
    }
}
