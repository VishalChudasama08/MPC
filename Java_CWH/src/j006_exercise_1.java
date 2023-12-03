import java.util.Scanner;
public class j006_exercise_1 {
    public static void main(String[] args) {
        System.out.println("Enter Subject-1 marks :- ");
        Scanner scan = new Scanner(System.in);
        float s1 = scan.nextFloat();
        System.out.println("Enter Subject-2 marks :- ");
        float s2 = scan.nextFloat();
        System.out.println("Enter Subject-3 marks :- ");
        float s3 = scan.nextFloat();
        System.out.println("Enter Subject-4 marks :- ");
        float s4 = scan.nextFloat();
        float total = s1+s2+s3+s4;
        float per = total/4;
        System.out.println("Your persistent is :- " + per + "%");
    }
}
