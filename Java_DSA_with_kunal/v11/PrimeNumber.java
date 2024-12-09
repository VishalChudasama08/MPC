package v11;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
//        Scanner sn = new Scanner(System.in);
//        int n = sn.nextInt();
//        boolean a = isPrime(n);
//        if(a){
//            System.out.println("number " + n + " is prime number");
//        } else {
//            System.out.println("number " + n + " is not prime number");
//        }
        int v = 100;
        System.out.print("Prime number in 1 to "+v+" is =>");
        System.out.print("1");
        int j = 1;
        for (int i = 2; i < v; i++) {
            if(isPrime(i)){
                System.out.print(", " + i);
                j++;
            }
        }
        System.out.println("\nTotal prime number in 1 to "+v+" is => " + j);
    }
    static boolean isPrime(int n){
        if (n <= 2){
            return  false;
        }

        int c = 2;
        while (c*c <= n){
            if (n%c == 0){
                return false;
            }
            c++;
        }
        if (c*c>n){
            return true;
        }
        return false;
    }
}
