import java.util.Arrays;
import java.util.Scanner;

public class InterviewQuestions {
	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static int nSum(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n + nSum(n - 1);
		}
	}

	public static boolean palindromeNumber(int n) {
		int a = n;
		int rev = 0;

		while (a > 0) {
			int x = a % 10;
			rev = (rev * 10) + x;
			a = a / 10;
		}
		if (n == rev) {
			return true;
		} else {
			return false;
		}
	}

	public static int secondLargest(int[] arr) {
		int a = 0;
		int b = 0;
		for (int i : arr) {
			if (a < i) {
				a = i;
			}
		}
		for (int i : arr) {
			if (i == a)
				continue;
			if (b < i) {
				b = i;
			}
		}
		return b;
	}

	public static int[] digitFrequency(int n) {
		int[] result = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		while (n > 0) {
			int a = n % 10;
			result[a] = result[a] + 1;
			n = n / 10;
		}
		return result;
	}

	public static char firstNonRepeating(String s) {
		int[] frequency = new int[256];

		// Count each character
		for (int i = 0; i < s.length(); i++) {
			frequency[s.charAt(i)]++;
		}

		// Find the first character with frequency 1
		for (int i = 0; i < s.length(); i++) {
			if (frequency[s.charAt(i)] == 1) {
				return s.charAt(i);
			}
		}

		// No non-repeating character found
		return '\0';
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = scan.nextInt();
		scan.close();

		System.out.println("Factorial of 5 is " + factorial(n));
		System.out.println("N number sum: " + nSum(n));

		System.out.println(palindromeNumber(121));
		int[] arr = { 10, 5, 20, 8, 15 };
		System.out.println(secondLargest(arr));
		System.out.println(Arrays.toString(digitFrequency(12233388)));
		System.out.println(firstNonRepeating("aabbcdde"));
	}
}
