
/*Write a c program to accept two values from user and display addition, subtraction,
multiplication, division of those value  */
import java.util.*;

public class L4_calculation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter first value: ");
		int a = scan.nextInt();
		System.out.print("\nEnter second value: ");
		int b = scan.nextInt();
		System.out.print("\naddition: " + (a + b) + " \nsubtraction: " + (a - b) + "\nmultiplication: " + (a * b)
				+ "\ndivision: " + (a / b));
	}
}
