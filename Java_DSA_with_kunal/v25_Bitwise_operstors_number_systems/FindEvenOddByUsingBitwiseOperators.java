package v25_Bitwise_operstors_number_systems;

import java.util.Scanner;

public class FindEvenOddByUsingBitwiseOperators {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int n = scan.nextInt();
        boolean v = isOdd(n);
        if (v)
            System.out.println("This number is Odd number");
        else
            System.out.println("This number is Even number");
    }
    private static boolean isOdd(int n){
        return (n & 1) == 1; // in and any number then, that number binary convert and in binary first number is 1 then odd, 0 then even.
        // AND(&)
        // 1 1 = 1
        // 1 0 = 0
        // 0 1 = 0
        // 0 0 = 0
    }
}
