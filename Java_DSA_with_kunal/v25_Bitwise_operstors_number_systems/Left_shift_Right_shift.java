package v25_Bitwise_operstors_number_systems;

public class Left_shift_Right_shift {
    public static void main(String[] args) {
        System.out.println("Left shift");
        // Left shift <<
        // formula => m << n = m * 2ⁿ = m * pow(2,n)

        System.out.println("2 << 3 => " + (2 << 3));
        // in left shift for binary add 0 in left side
        // ex. 2 << 3 then add three 0 in left side
        // 2 -> 10 then 10000 this answer 10000 -> 16
        // as per formula => 2*(2*2*2) = 16
        System.out.println("7 << 2 => " + (7 << 2));
        // ex. 7 << 2 then add two 0 in left side
        // 7 -> 111 then 11100, 11100 -> 28
        // as per formula => 7*(2*2) => 28


        System.out.println("\nRight shift");
        // Right shift
        // formula => m >> n = m * 2⁻ⁿ = m / 2ⁿ = m * pow(2, -n)

        System.out.println("42 >> 3 => " + (42 >> 3));// her answer is 5.25 but in int answer is 5
        // as per formula => 42/(2*2*2) = 42/8 = 5.25 = 5
        System.out.println("27 >> 3 => " + (27 >> 3));
        // in Right shift for binary remove number from left side
        // ex. 27 >> 3 then convert 27 to binary and remove three number
        // 27 -> 11111, remove three then 11 and 11 -> 3 answer is 3
        // as per formula => 27/(2*2*2) = 27/8 = 3.375 = 3

        System.out.println("20 >> 2 => " + (20 >> 2));
        // ex. 20 >> 2 , convert 20 to binary and remove 2 digit
        // 20 -> 10100, then remove two digit -> 101 -> 5
        // as per formula => 20/(2*2) = 20/4 = 5


    }
}
