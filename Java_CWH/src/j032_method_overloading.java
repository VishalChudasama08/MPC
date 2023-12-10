public class j032_method_overloading {
    static void hi(int x){
        x = 8;
    }
    static void arr(int [] x){
        x[0] = 8;
    }
    static void str(String s){
        s = "Vishal Chudasama";
    }
    static void hey(){
        System.out.println("Good Morning");
    }
    static void hey(int a){
        System.out.println("Good Morning" + a);
    }
    static void hey(int a, int b){
        System.out.println("Good Morning" + a + " and " + b);
    }
    public static void main(String[] args) {
        int a = 45;
        hi(a);
        System.out.println(a); // a value not change after calling method hi()

        int [] b = {10, 20, 30, 40, 50, 60, 70, 80};
        arr(b);
        System.out.println(b[0]); // b array 0 index value change after calling arr() method
        //value change because in java array is special object and here arr() method x variable excess array on its storage location like on pointer

        String st = "Vishal";
        str(st);
        System.out.println(st);// value not change, because String is not change on java it is only over rites,
        // and also String is special Object on java.


        //***method overloading***
        hey();

        int d = 4;
        hey(d);

        int f = 8, g = 8;
        hey(f, g);
    }
}
