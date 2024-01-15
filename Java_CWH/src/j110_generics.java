import java.util.ArrayList;
import java.util.Scanner;

// create your own generics
class newclass<V1, V2> {
    private V1 o1;
    private V2 o2;
    int b;

    public newclass(V1 o1, V2 o2, int b) {
        this.o1 = o1;
        this.o2 = o2;
        this.b = b;
    }

    public V1 getV1() {
        return o1;
    }
    public V2 getV2() {
        return o2;
    }
    public int getB() {
        return b;
    }
}

public class j110_generics {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(); // save all type value in this array, like php array but not sem
        arrayList.add("Vishal");
        arrayList.add(8);
        arrayList.add(true);
        arrayList.add(new Scanner(System.in));

        // int a = arrayList.get(0); // error because a is integer and arrayList[0] value is String
        int b = (int)arrayList.get(0); // not syntax error but this line shwing run time error because get(0) value is String

        // you can solw this problem use generics this arrayList ->
        // <Integer> is generics
        // set generics on class than this return and get only your set type value
        // in this case arrayList1 value return and get only integer
        ArrayList<Integer> arrayList1 = new ArrayList<>(); // save only integer value

        // you can set your own generics,
        // in this generic class 1st and 2nd value is only String and integer
        newclass<String, Integer> nc = new newclass<>("Vishal", 8, 143);
        // int st = nc.getV1(); // not allowing because getV1() return String
        String str = nc.getV1();
        System.out.println(str);

        // String c1 = nc.getV2(); // not allowing because getV2() return Integer
        int c = nc.getV2();
        System.out.println(c);
        int d = nc.getB();
        System.out.println(b);
    }
}
