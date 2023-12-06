import java.util.Scanner;
public class j019_practice_set_4 {
    public static void main(String[] args) {
        //Q-1
        int a = 10;
        // if (a = 11) { //showing error
        if (a == 11) {
            System.out.println("I am 11");
        }
        else{
            System.out.println("I am not 11");
        }

        //Q-2
        byte m1,m2,m3,m4;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your marks in Physics: ");
        m1 = scan.nextByte();

        System.out.print("Enter your marks in Chemistry: ");
        m2 = scan.nextByte();

        System.out.print("Enter your marks in Biology: ");
        m3 = scan.nextByte();

        System.out.print("Enter your marks in Mathematics: ");
        m4 = scan.nextByte();

        float total = (m1 + m2 + m3 + m4)/4f;
        if (total >= 35 && m1 >= 33 && m2 >= 33 && m3 >= 33 && m4 >= 33) {
            System.out.println("Congratulation, You have been promoted with " + total + "% percentage");
        }else{
            System.out.println("Sorry. You have not promoted Please try again later");
        }

        //Q-3
        float tax = 0;
        System.out.print("Enter Employee salary: ");
        float income = scan.nextFloat();
        if(income > 250000f && income <= 500000f){
            tax = (income*5)/100;
        }else if(income > 500000f && income <= 1000000f){
            tax = ((income*20)/100) + ((income*5)/100);;
        }else if(income > 1000000f){
            tax = ((income*20)/100) + ((income*5)/100) + ((income*30)/100);
        }
        System.out.println("total tax paid by the employee is: " + tax);

        //Q-4
        System.out.println("Enter Day Number: ");
        int s = scan.nextInt();
        switch (s) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> System.out.println("Try again! Enter only for 1 to 7");
        }

        //Q-5
        System.out.println("Enter Year Number: ");
        int l = scan.nextInt();
        if(l%4 == 0){
            System.out.println("The Year is Leap Year");
        }
        else{
            System.out.println("The Year Not Leap Year");
        }

        //Q-6
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter WebSite Name: ");
        String website = sc.nextLine();
        if(website.endsWith(".org")){
            System.out.println("This is an organizational website");
        }
        else if(website.endsWith(".com")){
            System.out.println("This is an Commercial website");
        }
        else if(website.endsWith(".in")){
            System.out.println("This is an Indian website");
        }
    }
}
