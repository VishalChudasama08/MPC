import java.util.Scanner;

class MyNewException extends Exception{
    @Override
    public String getMessage() {
        return "this is custom Exception Your 5 retrieve are completed and ";
    }
}

public class j086_practice_set_14 {
    public static void main(String[] args) {
        //Q-1
        // syntax Error -> int a = 7
        // ; expected

        //logical error
        int birth_year = 2002;
        int current_year = 2024;
        int age = birth_year - current_year; // not this is wrong logic, right logic is (age = current_year - birth_year;)

        // runtime error
        // System.out.println(88/0);

        //Q-2
        try {
            System.out.println(88/0);
        }
        catch (ArithmeticException e){
            System.out.println("HaHaHa...");
        }
        catch (IllegalAccessError i){
            System.out.println("HeHeHe...");
        }

        //Q-3
        int [] mark = new int[3];
        mark[0] = 11;
        mark[1] = 22;
        mark[2] = 33;

        Scanner sc = new Scanner(System.in);
        int index;
        int i = 0;
        while(i<5){
            try {
                System.out.print("Enter index number: ");
                index = sc.nextInt();
                System.out.printf("The value of marks[%d] is %d\n", index, mark[index]);
                break;
            }
            catch (Exception e){
                System.out.println("Invalid Index");
                i++;
            }
        }
        if(i>=5){
            System.out.println("your 5 retrieve are completed.");
        }

        // Q-4 & Q-5
        try {
            while(i<5){
                try {
                    System.out.print("Enter index number: ");
                    index = sc.nextInt();
                    System.out.printf("The value of marks[%d] is %d", index, mark[index]);
                    break;
                }
                catch (Exception e){
                    System.out.println("Invalid Index");
                    i++;
                }
            }
            if(i>=5){
                throw new MyNewException();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
