//005:- user input and processes it using Scanner class methods

import java.util.Scanner; // include java's Scanner class on this program

public class j005_user_input_scanner {
    public static void main(String[] args) {
        System.out.println("Taking Input from the user");
        Scanner sc = new Scanner(System.in);
        // Scanner is java's user input manage class and "sc" is its object,
        // System.in use to read input from the keyboard
        System.out.println("Enter Number 1");
        int a = sc.nextInt();
        // .nextInt its method of Scanner class, use to Scan only integer number
        System.out.println("Enter Number 2");
        float b = sc.nextFloat();
        // .nextFloat its method and use to Scan floating values
        float sum = a+b;
        System.out.println("The sum og a and b is : ");
        System.out.println(sum);

        System.out.println("Enter String values : ");
        String str = sc.next();
        // next() method use to only return 1 word on string value
        System.out.println(str);
        String str2 = sc.nextLine();
        // nextLine() method use to return next line of string value
        System.out.println(str2);

//        System.out.print("Enter a value if it is integer then true else false : ");
//        boolean a1 = sc.hasNextInt();
//        // hasNextInt() method use to scan a value and,
//        // check it is an Integer value or not return true and false
//        System.out.println(a1);
    }
}
