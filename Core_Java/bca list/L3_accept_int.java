
/*Write a c program to accept an integer value from user and print it on screen. */
import java.util.*;

public class L3_accept_int {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter integer value: ");
		int a = scan.nextInt();
		System.out.println("The value is " + a + "\n");
	}
}
