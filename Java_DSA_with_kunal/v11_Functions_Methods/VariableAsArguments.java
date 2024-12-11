package v11_Functions_Methods;

import java.util.Arrays;

public class VariableAsArguments {
    public static void main(String[] args) {
        fun(1,2,3,4,5,6,7,8,9);
        stringArray("vi", "sh", "al","he","he","he");
        fun2(2,3,1,2,34,5,6,7,8,9);
        fun3("vishal", 8, "Chudasama", "Vishal", "B");
    }
    static void fun(int ...v){ // than like integer array
        System.out.println(Arrays.toString(v));
    }
    static void stringArray(String ...v){
        System.out.println(Arrays.toString(v));
    }

    static void fun2(int a, int b, int ...f){
        System.out.println(a);
        System.out.println(b);
        System.out.println(Arrays.toString(f));
    }

    static void fun3(String a, int c, String ...b){ // write as last argument
        System.out.print(a);
        System.out.print(" "+c+" ");
        System.out.println(Arrays.toString(b));
    }
}
