import java.sql.SQLOutput;
import java.util.Scanner;
public class j007_practise_set_1 {
    public static void main(String[] args) {
        //Q-1 sum of number
        int a = 2;
        int b = 4;
        int c = 2;
        int sum = a+b+c;
        System.out.println(sum);

        //Q-2 calculate cgpa (10% of total)
        float s1 = 2;
        float s2 = 4;
        float s3 = 2;
        float cgpa = (s1+s2+s3)/30;
        System.out.println(cgpa);

        //Q-3 enter name and say hello <name> have a good day
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name ?");
        String name = scan.next();
        System.out.println("Hello " + name + " Have a good day ");

        //Q-4 km to mile
        System.out.print("Enter Kilometer value :- ");
        float km = scan.nextFloat();
        float mile = km * (0.621371F);
        System.out.println(km + "km = " + mile + "mile");

        //Q-5 check its integer
        System.out.println("Enter a Number : ");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.hasNextInt());
    }
}
