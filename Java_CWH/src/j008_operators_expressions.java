public class j008_operators_expressions {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int c = 2;
        // 1. Arithmetic operators => +,-,*,/,%
        // 2. Assignment Operators => =
        c += a + b;
        b *= a;
        a /= b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // 3. Comparison Operators => <, >, ==, <=, >=
        System.out.println(64>25);

        // 4. Logical Operators => !, ||, &&
        System.out.println(64>5 && 64>98);
        System.out.println(64>5 || 64>98);

        // 5. Bitwise operators => &, |
        System.out.println(2&3);
//        10
//        11
//      ------
//        10
    }
}
