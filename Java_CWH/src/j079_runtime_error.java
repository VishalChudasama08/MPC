import java.util.Scanner;
public class j079_runtime_error {
    public static void main(String [] argus){
        Scanner cn = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = cn.nextInt();
        System.out.println(n + " divided by 1000 is : " + 1000/n);
        // this is an error but on compile time not showing any error,
        // but on program run time showing error this is called Exception
        // if user enters 0 than this is an error because any number divide by 0 is infinite, and program exit
        // this type error is call Exception, and line number 7 showing ArithmeticException
    }
}
