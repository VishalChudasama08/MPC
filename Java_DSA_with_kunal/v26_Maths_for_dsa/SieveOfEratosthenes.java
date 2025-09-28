package v26_Maths_for_dsa;

import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        // Sieve of eratosthenes: algorithm to find prime number up to any given limit.

        // find prime number up to n (n itself also)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = scanner.nextInt();
        sieve(n);
    }
    static void sieve(int n){
        // create boolean n+1 index array
        boolean[] primes = new boolean[n+1]; // default all value is 'false'
        // here this boolean array index as number,
        // not prime number index is true AND prime number index is false
        // default all is value is 'false' now set not prime index value 'true'
        for (int i = 2; i*i <= n; i++) {
            if(!primes[i]){
                for (int j = i*2; j <= n; j += i) { // <-- all explain in bottom comment
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }

    // in "for (int j = i*2; j <= n; j += i)"
    // j=i*2 because, it is possible to i number is prime if it is prime number, and you set its index as true that is wrong
    // j += i because, j multiply by any number and that answer number is not prime number means i=2 than j=j+2; i=3 than j=j+3,...
    // ex. i=2 now for (int j = 4; j <= n; j += 2)
    // 2 * 1 = 2            3 * 1 = 3
    // 2 * 2 = 4            3 * 2 = 6
    // 2 * 3 = 6            3 * 33 = 66
    // ... 2 * 10 = 20      3 * 45 = 135
    // ... 2 * 25 = 50      3 * 7 = 21
    // ... than all table answer number is not prime number(because it divide by that number) without number itself (int j = i*2;)
}
