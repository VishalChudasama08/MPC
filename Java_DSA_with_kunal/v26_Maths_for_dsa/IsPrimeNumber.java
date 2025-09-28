package v26_Maths_for_dsa;

import java.util.Scanner;

public class IsPrimeNumber {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter Number: ");
//        int n = scanner.nextInt();
        int n=0;
        int[] a = {1,2,3};
        for (int i = 2; i < 100; i++) {
            n = i;
            if (isPrime(n)){
                System.out.println(n + " is Prime number");
            } else {
                System.out.println(n + " is Not Prime number");
            }
        }
    }

    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        int i=2;
        while (i*i <= n){
            if (n%i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
