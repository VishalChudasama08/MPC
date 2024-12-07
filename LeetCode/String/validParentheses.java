// String->easy Q-20 valid parentheses
package String;

import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        if (s.isEmpty()){
            return true;
        } else {
            return false;
        }

        /* best solution - because this question is in String and Stack if question in only String than my logic is best */
        /* Stack<Character> st = new Stack<>();
        for(char b : s.toCharArray()) {
            if(b == '(' || b == '{' || b == '[')
                st.push(b);

            else {
                if(st.isEmpty() ||
                    (b == ')' && st.peek() != '(') ||
                    (b == '}' && st.peek() != '{')  ||
                    (b == ']' && st.peek() != '[') ) {
                    return false;
                }
                st.pop();
            }

        }
        if (st.isEmpty())
            return true;
        return false; */
    }

    public static void main(String[] args) {
        String s = "({{{{}}}})"; // "[[[]", "({{{{}}}))", "()[]{}", "()", "[","{]"
        System.out.println(isValid(s));
    }
}
