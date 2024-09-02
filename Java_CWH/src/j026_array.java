public class j026_array {
    public static void main(String[] args) {
        // on java array is a object

//        int [] marks = new int[5]; // 5 is array size
//        marks[0] = 10;
//        marks[1] = 11;
//        marks[2] = 12;
//        marks[3] = 13;
//        marks[4] = 14;

        int [] m, s = new int[5]; // multiple array declaration and memory allocation
//        marks = new int[5];
//        student = new int[5];

        int[] marks = {10, 11, 12, 13, 14, 15};
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(marks[3]);
        System.out.println(marks[4]);

        String [] str = new String[5]; // Declaration String array
//        str = {"first", "second", "thierd", "forth", "five"}; // this is wrong.
//        Java does not support assigning values this way to an already declared array.

        str[0] = "first";
        str[1] = "second";
        str[2] = "third";
        str[3] = "fourth";
        str[4] = "five";

        String[] fruits = {"Apple", "Banana", "Orange"};

        // for loop
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        // for-each loop:
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
