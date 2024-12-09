package String;

public class FindFirstOccurrence {
    public static void main(String[] args) {
        String str1 = "vishal";
        String str2 = "sh";
        // "sadbutsad", "sad" // 0
        // "leetcode", "leeto" // -1
        // "hello", "ll" // 2
        // "aaa", "aaaa" //

        System.out.println(strStr(str1, str2));
    }
    public static int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;
        return haystack.indexOf(needle);



//        if (needle.isEmpty()) return 0;
//        if (haystack.length() < needle.length()) return -1;
//
//        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
////            System.out.println("Checking starting at index: " + i);
//            boolean match = true;
//
//            for (int j = 0; j < needle.length(); j++) {
////                System.out.println("Comparing haystack[" + (i + j) + "] = " + haystack.charAt(i + j) + " with needle[" + j + "] = " + needle.charAt(j));
//                if (haystack.charAt(i + j) != needle.charAt(j)) {
//                    match = false;
//                    break;
//                }
//            }
//
//            if (match) {
////                System.out.println("Match found at index: " + i);
//                return i;
//            }
//        }
//
////        System.out.println("No match found.");
//        return -1;
    }
}


