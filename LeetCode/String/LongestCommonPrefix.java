// String->easy Q-14
package String;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        String answer = "";
        int minLength = strs[0].length();
        for(String one: strs){
            if(minLength>one.length()){
                minLength = one.length();
            }
        }
        boolean valid = true;
        for(int i = 0; i<minLength;i++){
            char firstStrChar = strs[0].charAt(i);
            for(String str: strs){
                if(str.charAt(i) != firstStrChar){
                    valid = false;
                    break;
                }
            }
            if(valid){
                result.append(firstStrChar);
            }
        }
        if (!result.isEmpty()){
            answer=String.valueOf(result);
        }
        return answer;
    }
    public static void main(String[] args) {

        String[] strs = {"fow"};
        System.out.println(longestCommonPrefix(strs));

        // Input: strs = ["flower","flow","flight"]
        // Output: "fl"

        // Input: strs = ["dog","racecar","car"]
        // Output: ""
    }
}
