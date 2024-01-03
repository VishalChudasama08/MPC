import java.util.Scanner;

public class j082_nested_try_catch {
    public static void main(String[] args) {
        int [] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        Scanner sca = new Scanner(System.in);
        int index, value;
        boolean v = true;
        while(v){ // if all try block run than this loop close, else any catch block run (Exception showing) than loop is looping...
            try {
                System.out.print("Enter Index value you won to find: ");
                index = sca.nextInt();
                System.out.println(index + " Index number present value is: " + arr[index]);
                try {
                    System.out.print("Enter value you won to divide: ");
                    value = sca.nextInt();
                    System.out.println(value + " Divide value is: " + arr[index]/value);
                    v = false;
                }
                catch (ArithmeticException m){
                    System.out.println("Exception in Level 2 : " + m);
                }
            }
            catch(ArrayIndexOutOfBoundsException a){
                System.out.println("Exception in Level 1 : " + a);
            }
        }

        System.out.println("End Of Program");
    }
}
