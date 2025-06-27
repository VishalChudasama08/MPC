package v23_Rucursion;

public class Simple_Recursion {
    public static void main(String[] args) {
        int n = 1;
        recur_func(n);
    }
    // for more understanding debug recur_func(n) from main and see 'Threads & Variables' (in IntelliJ)
    private static void recur_func(int n){
        System.out.println(n);
        if (n >= 5){
            return;
        }
        recur_func(n+1);
    }
}
