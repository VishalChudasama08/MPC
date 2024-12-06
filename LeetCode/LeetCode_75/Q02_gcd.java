package LeetCode_75;//Q-2 The greatest common divisor of Strings

// For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
// Example 1:
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
//
//Example 2:
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"
//
//Example 3:
//Input: str1 = "LEET", str2 = "CODE"
//Output: ""
//
//Example 4:
//Input: str1 = "ABC", str2 = "ABCDEF"
//Output: ""

class SolutionQ2 {
    public String gcdOfStrings(String str1, String str2){
        // Check if str1 + str2 is equal to str2 + str1
        if (str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        int gcdValue = gcd(str1.length(), str2.length());

        String gcdString="";
        if(str1.length() > str2.length()){
            gcdString = str1.substring(0, gcdValue);
        } else {
            gcdString = str2.substring(0, gcdValue);
        }

        if (str1.equals(gcdString.repeat(str1.length() / gcdValue)) && str2.equals(gcdString.repeat(str2.length()/gcdValue))){
            return gcdString;
        }
        return "";
    }

    public int gcd(int a, int b){ // this is gct formula (Greatest common divisor)
        while(b != 0){ // find than value than divide both number
            int temp = b;
            b = a % b; // %() => If the first number (as per % sign -> first % second) is smaller than the second number, the result is that small number. Otherwise, follow the math division rule.
            // ex. 3%6=3, 7%5=2, 10%3=1, 7%5=2, 2%4=2, 4%2=0
            a = temp;
        }
        return a;
    }
}

public class Q02_gcd extends SolutionQ2{
    public static void main(String[] args) {
        SolutionQ2 solution = new SolutionQ2();
        String[][] testCases = { // here maximum possibility
            {"ABCABC", "ABCABC"}, {"ABABAB", "ABABAB"}, // Identical strings
            {"ABCABC", "ABC"}, {"ABABAB", "ABAB"}, // One string divides the other
            {"ABABABAB", "ABAB"}, {"AABBAABB", "AAB"}, // Same divisor, different lengths
            {"LEET", "CODE"}, {"ABC", "DEF"}, // No common divisor
            {"ABCDEF", "AB"}, {"ABCDE", "ABCDEF"}, // Different lengths, no common divisor
            {"ABC", ""}, {"", "ABC"}, // One empty string
            {"", ""}, // Both strings empty
            {"A", "A"}, {"A", "B"}, // Strings of length 1
            {"ABAB", "AB"}, {"AB", "AB"}, // Identical shorter strings
            {"ABABABAB", "ABAB"}, {"ABABAB", "AB"}, // Multiple occurrences of same substring
            {"ABCDEF", "ABCABC"}, {"AABBAA", "AAB"}, // Common substrings but no exact division
            {"XYZ", "PQR"}, {"HELLO", "WORLD"}, // Completely distinct strings
            {"ABAB", "ABA"}, {"ABCABC", "ABABAB"}, // Different repeating patterns
            {"AAAA", "AA"}, {"AAA", "AA"}, // Repeated character strings
            {"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"}, // Long repeating sequences
            {"ABCD", "EFGH"} // No repeating structure, same length
        };

        for (String[] testCase : testCases) {
            System.out.println("str1: " + testCase[0] + ", str2: " + testCase[1] + " => gcd: " + solution.gcdOfStrings(testCase[0], testCase[1]));
        }
    }
}
