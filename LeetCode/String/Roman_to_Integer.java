// String->easy Q-13
package String;

import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Map to store Roman numeral values
        Map<Character, Integer> romanValues = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int result = 0;
        int prevValue = 0;

        // Process each character from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanValues.get(currentChar);

            if (currentValue < prevValue) {
                // Subtraction case
                result -= currentValue;
            } else {
                // Addition case
                result += currentValue;
            }

            // Update previous value for next iteration
            prevValue = currentValue;
        }

        return result;
    }
}

public class Roman_to_Integer {
    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.romanToInt("IIV"));;
    }
}
