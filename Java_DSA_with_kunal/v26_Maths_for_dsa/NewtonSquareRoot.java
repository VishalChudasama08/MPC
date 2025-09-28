package v26_Maths_for_dsa;

public class NewtonSquareRoot {
    public static void main(String[] args) {
        System.out.printf(" %.3f",newtonSquareRoot(40));
    }
    static double newtonSquareRoot(double n){
        double x = n;
        double root;
        while (true){
            root = 0.5 * (x+(n/x));
            if(Math.abs(root-x) < 0.5){
                break;
            }
            x=root;
        }
        return root;
    }
}
