public class j035_recursion {
    static int factorial(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        else {
            return n * factorial(n-1); // recursion
        }
    }

    static int fibonacci(int n){
        if ( n == 0 ){
            return 0;
        }
        else if ( n == 1 ){
            return 1;
        }
        else{
            return (fibonacci(n-1)+fibonacci(n-2));
            /* explanation recursion
             * (1) i=n=0 return 0 (first if block)
             * (2) i=n=1 return 1 (else if block)
             * (3) i=n=2 return [recursion -> fibonacci(2-1), fibonacci(1){ return 1 (else if block) } => 1] + [recursion -> fibonacci(2-2), fibonacci(0){ return 0 (first if block) } => 0] = 1 + 0 = 1; (on last else block)
             * (4) i=n=3 return [recursion -> fibonacci(3-1), fibonacci(2){ run step-(3) } => 1] + [recursion -> fibonacci(3-2), fibonacci(1){ return 1 (else if block) } => 1] = 1 + 1 = 2; (on last else block)
             * (5) i=n=4 return [recursion -> fibonacci(4-1), fibonacci(3){ run step-(4) } => 2] + [recursion -> fibonacci(4-2), fibonacci(2){ run step-(3) } => 1] = 2 + 1 = 3; (on last else block)
             * (6) i=n=5 return [recursion -> fibonacci(5-1), fibonacci(4){ run step-(5) } => 3] + [recursion -> fibonacci(5-2), fibonacci(3){ run step-(4) } => 2] = 3 + 2 = 5; (on last else block)
             * (7) i=n=6 return [recursion -> fibonacci(6-1), fibonacci(5){ run step-(6) } => 5] + [recursion -> fibonacci(6-2), fibonacci(4){ run step-(5) } => 2] = 5 + 3 = 8; (on last else block)
             * .
             * .
             * .
             * (18) i=n=17 return [recursion -> fibonacci(17-1), fibonacci(16){ run step-(17) } => 987] + [recursion -> fibonacci(17-2), fibonacci(15){ run step-(16) } => 610] = 987 + 610 = 1597; (on last else block)
             * (19) i=n=18 return [recursion -> fibonacci(18-1), fibonacci(17){ run step-(18) } => 1597] + [recursion -> fibonacci(18-2), fibonacci(16){ run step-(17) } => 987] = 1597 + 987 = 2584; (on last else block)
             * (20) i=n=19 return [recursion -> fibonacci(19-1), fibonacci(18){ run step-(19) } => 2584] + [recursion -> fibonacci(19-2), fibonacci(17){ run step-(18) } => 1597] = 2584 + 1597 = 4181; (on last else block)
             */
        }
    }


    public static void main(String[] args) {
        int x = 5;
        System.out.println("Factorial of x is : " + factorial(x));

        int y = 20;
        for (int i = 0 ; i < y ; i++ ) {
            System.out.printf("%d, ", fibonacci(i));
        }
    }
}
