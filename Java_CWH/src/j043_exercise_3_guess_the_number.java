//import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

class GuessNumber{
    int pc_gn, user_gn;
    public GuessNumber(){
        Random rn = new Random();
        pc_gn = rn.nextInt(100) + 1; // generating in 1 to 100
        System.out.println("*** Guess The Number Bet-ween 1 to 100 ***");
        System.out.println("PC already Guested a Number You can Guess Than Number");
    }
    public void userGuess(){
        Scanner user = new Scanner(System.in);
        System.out.print("Enter Number : ");
        user_gn = user.nextInt();
        if(user_gn > 100 || user_gn == 0){
            System.out.print("Your Entered Number is not Allowed, Guess The Number Bet-ween 1 to 100 \nEnter Number : ");
            user_gn = user.nextInt();
        }
    }
    public void check(){
        if (user_gn == pc_gn){
            System.out.println("Congratulation...!");
        } else if(user_gn > pc_gn){
            System.out.println("This Number is Bigger");
        } else{
            System.out.println("This Number is Smaller");
        }
    }
}
public class j043_exercise_3_guess_the_number {
    public static void main(String[] args) {
        GuessNumber g = new GuessNumber();
        boolean v = true;
        int i = 0;
        do {
            g.userGuess();
            g.check();
            i++;
            if(g.user_gn == g.pc_gn){
                System.out.println("Total Try : " + i);
                break;
            }
        } while (v);
    }
}
