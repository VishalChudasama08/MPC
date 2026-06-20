/* 
 * Write a program to Input two values and swap them.
(without using third variable)
 */
public class L12_swap {
	public static void main(String[] args) {
		int x = 50;
		int y = 20;
		System.out.print("\nx = " + x + "\ny = " + y);

		x = x + y;
		y = x - y;
		x = x - y;
		System.out.print("\n\nx = " + x + "\ny = " + y);

	}
}
