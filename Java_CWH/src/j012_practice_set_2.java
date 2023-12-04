import java.util.Scanner;
public class j012_practice_set_2 {
    public static void main(String[] args) {
        //Q-1
        float a = 7/4*9/2; // this is getting wrong answer
        float b = 7/4f*9/2f; // this is a right way
        System.out.println(a);
        System.out.println(b);

        //Q-2
        //Encrypting grade
        char grade = 'G';
        grade = (char)(grade + 15); // char + int = int then, here convert int to char
        System.out.println(grade);
        //Decrypting the grade
        grade = (char)(grade - 15);
        System.out.println(grade);

        //Q-3
        Scanner scan = new Scanner(System.in);
        int c = 8;
        int d = scan.nextInt();
        System.out.println(d<c);

        //Q-4
        float v=8F,u=2F,s=7F;
        float f = (v*v - u*u) / (2F*a*s);
        System.out.println(f);

        //Q-5
        int x = 7;
        int y = 7*49/7+35/7; //(7*(49/7))+(35/7); all sem
        System.out.println(y);
    }
}
