package v11;

public class Shadowing {
    static int v = 80;

    public static void main(String[] args) {
        System.out.println("shadow variable " + v); // 80

        int v;
//        System.out.println(v); // error
        v = 8;

        System.out.println(v); // 8
        fun1();
        fun2(v);
        fun3(v);
    }
    static void fun1(){
        System.out.println("fun1 => " + v); // 80
    }
    static void fun2(int b){
        System.out.println("fun2 => " + b); // 8
        System.out.println("fun2 => " + v); // 80
    }
    static void fun3(int v){
        System.out.println("fun3 => " + v); // 8
    }
}
