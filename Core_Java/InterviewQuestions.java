import java.util.Arrays;
import java.util.HashMap;
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

	public static boolean palindromeString(String s) {
		String b = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		StringBuilder a = new StringBuilder(b);
		a.reverse();

		// System.out.println(s + "\n" + a + "\n" + b);

		return a.toString().equals(b);
	}

	// Two Sum: Given an array of integers and a target value, find a pair of
	// numbers that add up to the target. Return their indices.
	public static int[] twoSum(int[] numbers, int target) {
		// int[] arr = { 0, 0 };
		// for (int i = 0; i < numbers.length; i++) {
		// for (int j = 1; j < numbers.length; j++) {
		// if (numbers[i] + numbers[j] == target) {
		// arr[0] = i;
		// arr[1] = j;
		// return arr;
		// }
		// }
		// }
		// return arr;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			int needed = target - numbers[i];
			if (map.containsKey(needed)) {
				return new int[] { map.get(needed), i };
			}
			map.put(numbers[i], i);
		}
		return new int[] { -1, -1 };
	}

	public static String reverseWordInSentence(String s) {
		String[] words = s.trim().split("\\s+");
		StringBuilder ans = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			if (i == 0) {
				ans.append(words[i]);
			} else {
				ans.append(words[i] + " ");
			}
		}
		// System.out.println(s.length() + " " + ans.length());
		return ans.toString();
	}

	public static int secondLargest(int[] arr) {
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		for (int i : arr) {
			if (a < i) {
				a = i;
			} else {
				if (b < i && i != a) {
					b = i;
				}
			}
		}
		// for (int i : arr) {
		// if (i == a)
		// continue;
		// if (b < i) {
		// b = i;
		// }
		// }
		return b;
	}

	public static int[] digitFrequency(int n) {
		int[] result = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		while (n > 0) {
			int a = n % 10;
			result[a] += 1;
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

	public static int reverse(int n) {
		int ans = 0;
		while (n > 0) {
			int x = n % 10;
			ans = (ans * 10) + x;
			n = n / 10;
		}
		return ans;
	}

	public static void aFizzBuzzVariant(int n) {
		for (int i = 1; i <= 15; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print("FizzBuzz ");
			} else if (i % 3 == 0) {
				System.out.print("Fizz ");
			} else if (i % 5 == 0) {
				System.out.print("Buzz ");
			} else {
				System.out.print(i + " ");
			}
		}
	}

	public static void characterFrequencyCount(String src) {
		// as per time i am lave it
	}

	public static boolean armstrongNumberCheck(int n) {
		int d = 0;
		int num = n;
		while (num > 0) {
			d++;
			num /= 10;
		}
		num = n;
		int result = 0;
		while (num > 0) {
			int rem = num % 10;
			result += Math.pow(rem, d);
			// System.out.println(rem + " " + Math.pow(rem, d) + " " + d);
			num /= 10;
		}
		System.out.println(result);

		return result == n;
	}

	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int[] merged = new int[arr1.length + arr2.length];
		int j = 0;
		for (int i = 0; i < arr1.length; i++) { // you not say, so i am consider both array size is same
			if (arr1[i] < arr2[i]) {
				merged[j] = arr1[i];
				j++;
				merged[j] = arr2[i];
				j++;
			} else {
				merged[j] = arr2[i];
				j++;
				merged[j] = arr1[i];
				j++;
			}
		}
		return merged;
	}

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// System.out.print("Enter number: ");
		// int n = scan.nextInt();
		// scan.close();

		aFizzBuzzVariant(15);
		// characterFrequencyCount("success");

		System.out.println(armstrongNumberCheck(123));
		int[] arr1 = { 1, 3, 5 };
		int[] arr2 = { 2, 4, 6 };
		System.out.println(Arrays.toString(mergeTwoSortedArrays(arr1, arr2)));

		// System.out.println("Factorial of 5 is " + factorial(n));
		// System.out.println("N number sum: " + nSum(n));

		// System.out.println(palindromeNumber(121));
		// System.out.println(palindromeString("A man a plan a canal Panama"));
		// System.out.println(reverseWordInSentence("Zeus Learning is hiring"));

		// int[] arr = { 10, 5, 20, 8, 20, 15 };
		// int[] ans = twoSum(arr, 13);
		// System.out.println(Arrays.toString(ans));
		// System.out.println(secondLargest(arr));

		// System.out.println(Arrays.toString(digitFrequency(12233388)));

		// System.out.println(firstNonRepeating("aabbcdde"));

		// System.out.println(reverse(12345));
	}
}
