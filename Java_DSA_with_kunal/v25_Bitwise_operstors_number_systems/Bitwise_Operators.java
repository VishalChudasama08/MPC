package v25_Bitwise_operstors_number_systems;

public class Bitwise_Operators {
    public static void main(String[] args) {
        //  AND &        OR |         NOT !      XOR ^
        // 1 1 = 1      1 1 = 1       1 = 0     1 1 = 0
        // 1 0 = 0      1 0 = 1       0 = 1     1 0 = 1
        // 0 1 = 0      0 1 = 1                 0 1 = 1
        // 0 0 = 0      0 0 = 0                 0 0 = 0

        System.out.println("5 & 1 = " + (5 & 1));
        // convert this number to binary then do AND &
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
    }
}
