package v21_String_and_StringBuider;

import java.util.Arrays;

public class PrintLnPrintInString {
    public static void main(String[] args) {
        System.out.println(18); // yes, 18 is number but in output showing 18 is string println use .toString() method for pring anything

        // example =>
        int [] intArray = {1, 2, 3, 4};
        System.out.println(intArray); // here integer array not print properly, because println not applicable to convert array to string
        System.out.println(Arrays.toString(intArray));

        System.out.println(new String[]{"Vishal", "Chudasama"});
        String[] stringArray = {"Vishal", "Chudasama"};
        System.out.println(Arrays.toString(stringArray));

        String nullString = null;
        System.out.println(nullString); // println done with null

        // like language c type print ->
        System.out.printf("hey i am %s. and my favorite number is %d\n", "Vishal", 8);
        System.out.printf("This is character %c and this is float %.2f", 'v', 18.181235);

        System.out.println("\n\n\n\n");
        // Sample data
        String studentName = "Chudasama Vishal";
        char grade = 'A';
        int age = 20;
        long studentId = 123456789L;
        double gpa = 3.856;
        float percentage = 92.75f;
        boolean passed = true;
        int credits = 15;

        // Report Card Header
        System.out.printf("=== Student Report Card ===%n");

        // Using %s for String
        System.out.printf("Name: %s%n", studentName);

        // Using %c for char
        System.out.printf("Grade: %c%n", grade);

        // Using %d for decimal integer (int)
        System.out.printf("Age: %d years%n", age);

        // Using %o for octal (student ID in octal)
        System.out.printf("Student ID (octal): %o%n", studentId);

        // Using %x and %X for hexadecimal (student ID in hex)
        System.out.printf("Student ID (hex lowercase): %x%n", studentId);
        System.out.printf("Student ID (hex uppercase): %X%n", studentId);

        // Using %f with precision for floating-point (GPA)
        System.out.printf("GPA: %.2f%n", gpa);

        // Using %e and %E for scientific notation (GPA in scientific form)
        System.out.printf("GPA (scientific lowercase): %e%n", gpa);
        System.out.printf("GPA (scientific uppercase): %E%n", gpa);

        // Using %g and %G for general floating-point (percentage)
        System.out.printf("Percentage (general): %g%n", percentage);
        System.out.printf("Percentage (general uppercase): %G%n", percentage);

        // Using %b for boolean
        System.out.printf("Passed: %b%n", passed);

        // Using %,d for grouping separator (credits with commas)
        System.out.printf("Credits Earned: %,d%n", credits);

        // Using flags: left-justify, zero-padding, and sign
        System.out.printf("Credits (left-justified, width 10): %-10d%n", credits);
        System.out.printf("Credits (zero-padded, width 5): %05d%n", credits);
        System.out.printf("Credits (with sign): %+d%n", credits);

        // Using %% for literal percent
        System.out.printf("Completion Rate: 100%%%n");

        // Using %n for platform-specific newline
        System.out.printf("End of Report%n");
    }
}
