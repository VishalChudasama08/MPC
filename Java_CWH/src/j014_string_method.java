public class j014_string_method {
    public static void main(String[] args) {
        String name = "Vishal";
        System.out.println(name);

        int length  = name.length(); // .length() return string length
        System.out.println(length);

        String lname = name.toLowerCase();
        System.out.println(lname);

        String uname = name.toUpperCase();
        System.out.println(uname);

        String sname = name.substring(2); // .substring() use to star index number string return
        System.out.println(sname);

        String saname = name.substring(2,5); // start 2 and end 5 index
        System.out.println(saname);

        String rname = name.replace('V', 'G');
        System.out.println(rname);

        String raname = name.replace("shal", "ta");
        System.out.println(raname);

        System.out.println(name.startsWith("Vi"));
        System.out.println(name.startsWith("Gi"));

        System.out.println(name.endsWith("al"));
        System.out.println(name.endsWith("ta"));

        System.out.println(name.charAt(2)); // return index number character

        System.out.println(name.indexOf('s')); //return index number

        System.out.println(name.lastIndexOf('l'));

        System.out.println(name.equals("Vishal"));
        System.out.println(name.equals("vishal"));
        System.out.println(name.equals("vita"));

        System.out.println(name.equalsIgnoreCase("ViShAl"));
        System.out.println(name.equalsIgnoreCase("vita"));

        String newstring = "    Hey There!    ";
        System.out.println(newstring);

        String trimstring = newstring.trim(); // .trim() clear starting and ending spase
        System.out.println(trimstring);

        // chatGPT
        String str1 = "apple";
        String str2 = "banana";
        System.out.println("str1: " + str1 + ", str2: " + str2);

        int compareTo = str1.compareTo(str2); // Compares two strings lexicographically.
        // Negative value (str1 < str2)
        System.out.println("str1 compareTo str2 :- " + compareTo);

        String concat = str1.concat(str2); // Concatenates the specified string to the end of this string.
        System.out.println("str1 concat str2 :- " + concat); // "applebanana"

        String str = "Hello, World!";
        System.out.println("str is : "+str);
        boolean contains = str.contains("World"); // Checks if the string contains the specified sequence.
        System.out.println("contains `World` : " + contains); // true

        boolean endsWith = str.endsWith("World!"); // Checks if the string ends with the specified suffix.
        System.out.println("endsWith `World!` : " + endsWith); // true

        boolean startsWith = str.startsWith("Hello"); // Checks if the string starts with the specified prefix.
        System.out.println("startsWith `Hello` : " + startsWith); // true

        String substr = str.substring(7); // Returns a new string that is a substring of this string.
        System.out.println("substr in str is: " + substr);// "World!"

        System.out.println("str toLowerCase is: "+str.toLowerCase()); // "hello, world!"
        System.out.println("str toUpperCase is: "+str.toUpperCase()); // "HELLO, WORLD!"

//        Returns a new string with leading and trailing whitespace removed.
        System.out.println("A trim of `       Hello, World!       ` is: " + "       Hello, World!       ".trim()); // "Hello, World!"

        boolean equals = str1.equals(str2); // Compares this string to the specified world/string/object.
        System.out.println("equals `str2`: " + equals); // false
        boolean equals1 = str1.equals("apple"); // Compares this string to the specified world/string/object.
        System.out.println("equals `apple`: "+ equals1); // true

        boolean equalsIgnoreCase = str1.equalsIgnoreCase("Apple"); // Returns the index of the first occurrence of the specified character.
        System.out.println("equalsIgnoreCase `Apple` : " + equalsIgnoreCase); // true

        String str3 = "";
        boolean isEmpty = str3.isEmpty(); // Checks if the string is empty.
        System.out.println("str2 isEmpty : " + "vishal".isEmpty());// false
        System.out.println("str3 isEmpty : " + isEmpty);// true

        int length1 = str.length(); // Returns the length of the string.
        System.out.println("str length is : " + length1);// 5

        String replaced = str.replace('l', 'p'); // Returns a new string resulting from replacing all occurrences of oldChar with newChar.
        System.out.println("replace `l` to `p` in str is : " + replaced);// "Heppo, Worpd!"

        String str4 = "apple,banana,orange";
        System.out.println("str4 is : " + str4);

        // Split the string by comma "," and return array
        String[] fruitArray = str4.split(","); // Splits the string around matches of the given regular expression.
        System.out.println("str4 split in `,` is : ");
        // Printing the resulting array
        for (String fruit : fruitArray) {
            System.out.println(fruit);
        }

        int num = 123;
        // Returns the string representation of the int argument.
        String str5 = String.valueOf(num);
        System.out.println(str5); // "123"
    }
}
