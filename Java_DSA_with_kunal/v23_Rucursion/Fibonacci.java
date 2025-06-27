package v23_Rucursion;

import java.io.IOException;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        mode();
    }

    private static void mode() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("0 : Find n th Fibonacci Number");
        System.out.println("1 : Get 0 to n th Fibonacci Number Series");

        System.out.print("Enter Your Choice (0/1): ");
        int n = scanner.nextInt();

        switch (n) {
            case 0 -> {
                System.out.print("Enter n th Number: ");
                int a = scanner.nextInt();
                int number = fibonacci(a-1);
                System.out.println(a + "th fibonacci number is " + number);

                System.out.print("Press Enter to continue...");
                int key = System.in.read(); // waits for key press
                if (key == '\n' || key == '\r') { // handles Enter
                    mode();
                }
            }
            case 1 -> {
                System.out.print("Enter n th Number: ");
                int b = scanner.nextInt();
                int [] numbers = new int[b];
//                for (int i = 0; i < b; i++) {
//                    numbers[i] = fibonacci(i);
//                }
                for (int i = 0; i < b; i++) {
                    numbers[i] = fibonacci_faster(i);
                }
                System.out.print("Fibonacci Number Of 0 to " + b + " is : ");
                for (int i = 0; i < b; i++) {
                    System.out.print(numbers[i] + ", ");
                }
                System.out.print("\nPress Enter to continue...");
                int key = System.in.read(); // waits for key press
                if (key == '\n' || key == '\r') { // handles Enter
                    mode();
                }
            }
            default -> {
                System.out.println("Only enter 0 or 1 !");

                System.out.print("Press Enter to continue...");
                int key = System.in.read(); // waits for key press
                if (key == '\n' || key == '\r') { // handles Enter
                    mode();
                }
            }
        }
    }

    private static int fibonacci(int n) {
        if(n<2){
            if (n<0){
                return 0;
            }
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    private static int fibonacci_faster(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }


}
