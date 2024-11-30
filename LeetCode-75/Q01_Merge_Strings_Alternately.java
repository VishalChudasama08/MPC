// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//Return the merged string.
//
//
//Example 1:
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//
//Example 2:
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//
//Example 3:
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"


class SolutionQ1 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merge = new StringBuilder();

        if(word1.length() == word2.length()){
            for(int i=0; i<word1.length();i++){
                merge.append(String.valueOf(word1.charAt(i))).append(String.valueOf(word2.charAt(i)));
            }
        } else if (word1.length() <= word2.length()){
            int i=0;
            for(i=0; i<word1.length();i++){
                merge.append(String.valueOf(word1.charAt(i))).append(String.valueOf(word2.charAt(i)));
            }
            for(int j=i; j<word2.length();j++){
                merge.append(String.valueOf(word2.charAt(j)));
            }
        } else {
            int i=0;
            for(i=0; i<word2.length();i++){
                merge.append(String.valueOf(word1.charAt(i))).append(String.valueOf(word2.charAt(i)));
            }
            for(int j=i; j<word1.length();j++){
                merge.append(String.valueOf(word1.charAt(j)));
            }
        }

        return merge.toString();
    }
}
public class Q01_Merge_Strings_Alternately extends SolutionQ1 {
    public static void main(String[] args) {
        SolutionQ1 solutionQ1 = new SolutionQ1();
        String[][] textStrings = {{"abc", "pqr"}, {"ab", "pqrs"}, {"abcd", "pq"}};

        for(String[] testString :textStrings){
            System.out.println("word1 " + testString[0] + ", word2 " + testString[1] + " => " + solutionQ1.mergeAlternately(testString[0], testString[1]));
        }
    }
}
