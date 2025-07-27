package v25_Bitwise_operstors_number_systems;

import java.util.ArrayList;
import java.util.Arrays;

public class Bitwise_Operators {
    public static void main(String[] args) {
        //  AND &        OR |         NOT !      XOR ^
        // 1 1 = 1      1 1 = 1       1 = 0     1 1 = 0
        // 1 0 = 0      1 0 = 1       0 = 1     1 0 = 1
        // 0 1 = 0      0 1 = 1                 0 1 = 1
        // 0 0 = 0      0 0 = 0                 0 0 = 0

        // NOTE: Bitwise operator work on bit. you sent decimal, but it converts binary then work on it

        System.out.println("5 & 1 = " + (5 & 1));
        // convert this (here 5, 1) number to binary then do AND &
        // 5 -> 101
        // 1 -> 001
        // & -> 001
        // 001 -> 1

        System.out.println("5 & 2 = " + (5 & 2));
        // 5 -> 101
        // 2 -> 010
        // & -> 000 -> 0
        // 110
        // 111
        // 110

        System.out.println("6 & 7 = " + (6 & 7));

        // using bitwise operator
        int [] binary = DecimalToBinary(4);
        System.out.println(Arrays.toString(binary));
    }

    private static int[] DecimalToBinary(int decimal){
        int size = Integer.SIZE, bit, flag=0;
        ArrayList<Integer> binaryList = new ArrayList<>();

        for (int i = size-1; i >= 0; i--) {
            bit = (decimal >> i) & 1;

            if(bit == 1){
                flag = 1;
            }
            if(flag == 1){
                binaryList.add(bit);
            }
        }
        int [] binary = new int[binaryList.size()];
        for(int i=0; i< binaryList.size(); i++){
            binary[i] = binaryList.get(i);
        }
        return binary;
    }
}
