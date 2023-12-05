import java.util.Scanner;
public class j013_string {
    public static void main(String[] args) {
        String name = new String("This is string and java \"String\" is a class.");
        System.out.println(name);
        String name1 = "string is especial sport on java, you direct write string like this line (different between other class)";
        System.out.println(name1);
        // java not allow to change string, string is immutable (not changeable) on java
        // if you required to change then, create a copy and change it, but original is not changeable.
        int a = 8;
        float b = 8.8f;
        char c = 'V';
        String name2 = "This is String";
        System.out.printf("integer b = %d, Float b = %1.1f, Character c = %c, String name2 = %s", a, b, c, name2);
        // %1.2f is like a one number then dot(.) then two number
        //like c language java printf,
        // integer -> %d
        // float -> %f
        // character -> %c
        // string -> %s
        System.out.format("integer b = %d, Float b = %f, Character c = %c, String name2 = %s \n\n", a, b, c, name2);
        // format like printf

        Scanner scan = new Scanner(System.in);
        String st = scan.nextLine(); // user enter string value
        System.out.println(st);
    }
}
