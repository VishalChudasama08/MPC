package v11;

import java.util.Arrays;

public class Overloading {
    public static void main(String[] args) {
        demo();
        demo(8);
        demo(8.12f);
        demo("Vishal");
        demo(true);
        demo('V');
        demo(1,2,3,4,5,6);
        demo("vi", "sh", "al");

        int a = sum(1,2);
        System.out.println("two argument sum is = " + a);
        int b = sum(1,2,3);
        System.out.println("tree argument sum is = " + b);
        int c = sum(1,2,3,4);
        System.out.println("for argument sum is = " + c);
        int d = sum(1,2,3,4,5,6,7,8,9);
        System.out.println("n argument sum is = " + d);
    }
    static void demo(){
        System.out.println("demo method without arguments");
    }
    static void demo(int a){
        System.out.println("demo method with one integer argument = " + a);
    }
    static void demo(Float a){
        System.out.println("demo method with one Float argument = " + a);
    }
    static void demo(String a){
        System.out.println("demo method with one string argument = " + a);
    }
    static void demo(boolean a){
        System.out.println("demo method with one boolean argument = " + a);
    }
    static void demo(char a){
        System.out.println("demo method with one character argument = " + a);
    }
    static void demo(int ...a){
        System.out.println("demo method with one integer array argument = " + Arrays.toString(a));
    }
    static void demo(String ...a){
        System.out.println("demo method with one string array argument = " + Arrays.toString(a));
    }

    static int sum(int a, int b){
        return a+b;
    }
    static int sum(int a, int b,  int c){
        return a+b+c;
    }
    static int sum(int a, int b, int c, int d){
        return a+b+c+d;
    }

    static int sum(int ...v){
        int r=0;
        for(int a:v){
            r += a;
        }
        return r;
    }
}
