package v26_Maths_for_dsa;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        factorsMethod1(20);
        System.out.println();
        factorsMethod2(20);
        System.out.println();
        factorsMethod3(20);
    }
    static void factorsMethod1(int n){
        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                System.out.print(i + " ");
            }
        }
    }
    static void factorsMethod2(int n){ // best
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n/i + " ");
                }
            }
        }
    }
    static void factorsMethod3(int n){ // best with sorted order
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
