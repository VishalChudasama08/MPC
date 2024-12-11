package v11_Functions_Methods;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isArmstrong(sc.nextInt()));

        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)){
                System.out.print(i + ", ");
            }
        }
    }
    static boolean isArmstrong(int n){
        int original = n;
        int sum = 0;
        while (n>0){
            int s = n%10;
            sum = sum + s*s*s;
            n = n/10;
        }

        return original == sum; // simple if condition ture than return true else false
    }
}
