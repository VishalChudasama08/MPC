import java.util.Scanner;

public class j081_handling_specific_exception {
    public static void main(String[] args) {
        int [] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        Scanner sca = new Scanner(System.in);
        System.out.print("Enter Index value you won to find: ");
        int index = sca.nextInt();

        System.out.print("Enter value you won to divide: ");
        int value = sca.nextInt();

        try {
            System.out.println(index + " Index number present value is: " + arr[index]);
            System.out.println(value + " Divide value is: " + arr[index]/value);
        }
        catch(ArrayIndexOutOfBoundsException a){ // if Array Index Out Of Bounds than run this Exception catch block
            System.out.println("Array Index Out Of Bounds Exception");
        }
        catch(ArithmeticException m){ // if Divide by zero than run this Exception catch block
            System.out.println("Divide by zero Exception");
        }
        catch (Exception e){ // all types of Exception cover in this block
            System.out.println(e);
        }

        // only run 1 block on this type try-catch
    }
}
