package v13_linear_search;

public class Search_In_String {
    public static void main(String[] args) {
        String str = "Vishal";
        char target = 'a';

        if (!searchInString(str, target)) System.out.println("'" + target + "' is not found in provided string");
        else System.out.println("Yes, '"+ target + "' is present in provided string");
    }

    static boolean searchInString(String str, char target){
        if (str.isEmpty()) return false;
        for (char c:str.toCharArray()) { // str to converting char array for foreach loop
            if (c == target){
                return true;
            }
        }
        return false;
    }
}
