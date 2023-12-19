import java.util.Random; //use to generating random number
import java.util.Scanner;
public class j020_exercise_2_rock_paper_scissor {
    public static void main(String[] args) {
        System.out.println("Welcome To Rock-Paper-Scissor Game");
        for (int i = 0; i < 5; i++) {
            Random rd = new Random(); //rd -> generating random number
            int pc_choice_number = rd.nextInt(3) + 1; // use .nextInt(3) to generating in 0 to 2 (0,1,2), three random number, +1 to convert in like 1,2,3
//        System.out.println(pc_choice_number);
            String pc_choice = "unset";
            switch (pc_choice_number) {
                case 1 -> {
                    pc_choice = "Rock";
                }
                case 2 -> {
                    pc_choice = "Paper";
                }
                case 3 -> {
                    pc_choice = "Scissor";
                }
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("Hint: Rock = r, Paper = p, Scissor = s \nNow Choosing You: ");
            String your_choice = scan.next();

            int your_choice_number = 0;
            switch (your_choice) {
                case "r" -> {
                    your_choice = "Rock";
                    your_choice_number = 1;
                }
                case "p" -> {
                    your_choice = "Paper";
                    your_choice_number = 2;
                }
                case "s" -> {
                    your_choice = "Scissor";
                    your_choice_number = 3;
                }
            }

            System.out.println("Your Choice is : " + your_choice);
            System.out.println("PC Choice is : " + pc_choice);

//        System.out.println(pc_choice_number);
//        System.out.println(your_choice_number);

            if ((pc_choice_number == 1 && your_choice_number == 1) || (pc_choice_number == 2 && your_choice_number == 2) || (pc_choice_number == 3 && your_choice_number == 3)) {
                System.out.println("\nMatch Tie!!! Try Again\n");
            }
            if ((pc_choice_number == 1 && your_choice_number == 2) || (pc_choice_number == 2 && your_choice_number == 3) || (pc_choice_number == 3 && your_choice_number == 1)) {
                System.out.println("\nYou Are Winner\n");
            }
            if ((pc_choice_number == 1 && your_choice_number == 3) || (pc_choice_number == 2 && your_choice_number == 1) || (pc_choice_number == 3 && your_choice_number == 2)) {
                System.out.println("\nPC Are Winner\n");
            }
        }
    }
}
