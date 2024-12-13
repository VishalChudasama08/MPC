package Q1295; // find-numbers-with-even-number-of-digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
public class FindEvenNumberOfDigits {
    public static void main(String[] args) {
        int [] nums = {555,9011,482,1771};
        System.out.println(findNumbers(nums));
    }
    public static int findNumbers(int[] nums) {
        int counter = 0;
        for (int element:nums) {
            int digit = findDigit(element);
            if (findEven(digit)) counter++;
        }
        return counter;
    }
    public static int findDigit(int element){
        return (int)(Math.log10(element)+1);
    }
    // this is not a fast way to find digit in number
    public static int findDigit2(int element){
        int num = element;
        int n = 0;
        while (num != 0){
            num = num/10;
            n++;
        }
        return n;
    }
    public static boolean findEven(int digit){
        return digit%2==0;
    }
}
