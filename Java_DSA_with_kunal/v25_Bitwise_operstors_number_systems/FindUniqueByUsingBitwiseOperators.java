package v25_Bitwise_operstors_number_systems;

public class FindUniqueByUsingBitwiseOperators {
    public static void main(String[] args) {
        int [] arr = {1,5,7,3,4,8,5,1,3,7,4}; // here only 8 is one time another all in 2 times

        System.out.println(ans(arr));
    }
    public static int ans(int [] arr){
        int unique = 0;

        for(int n : arr){
            unique ^= n; // unique = unique ^ n // first unique = 0 ^ 1 = 1
        }
        // 0 ^ 1 = 1 -> 0^1=1
        // 1 ^ 5 = 4 -> 001^101=100
        // 4 ^ 7 = 3 -> 100^111=011
        // ....
        // 12 ^ 4 = 8 -> 1100^0100=1000 => 8

        return unique;
    }
}
