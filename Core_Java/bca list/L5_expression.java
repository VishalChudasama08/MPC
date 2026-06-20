
/*Write a program to read the value of x & y and print the result of the following expression in one line.
(a) (x + y) / (x – y) (b) (x + y) / 2 (c) (x + y) * (x – y) 
*/
import java.util.*;

public class L5_expression {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter x value: ");
		int x = scan.nextInt();
		System.out.print("\nEnter y value: ");
		int y = scan.nextInt();

		System.out.println("\n(a) (x + y) / (x - y) = " + (x + y) / (x - y));
		System.out.println("(b) (x + y) / 2 = " + (x + y) / 2);
		System.out.println("(c) (x + y) * (x - y) = " + (x + y) * (x - y));
	}
}
