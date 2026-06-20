
/*
 * Write a program in C to read character from user and change upper to lower ?
 */
import java.util.*;

public class L19_char_upper_to_lower {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter character: ");
		char u = scan.next().charAt(0);

		if (u >= 'A' && u <= 'Z') {
			System.out.println(u);
		}
		// char l = u+32;
	}
}
