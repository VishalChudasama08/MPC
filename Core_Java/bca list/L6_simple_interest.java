
/* Write a program to calculate the simple interest */
import java.util.*;

public class L6_simple_interest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter P: ");
		int p = scan.nextInt();
		System.out.print("\nEnter R: ");
		int r = scan.nextInt();
		System.out.print("\nEnter n: ");
		int n = scan.nextInt();
		scan.close();

		System.out.print("\nSimple interest: " + ((p / 100) * r * n));
	}
}
