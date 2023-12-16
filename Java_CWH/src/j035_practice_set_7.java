public class j035_practice_set_7 {
    static void multiplication(int v){
        for (int i = 1; i <= 10; i++) {
            System.out.format("%d X %d = %d\n",v,i,v*i);
        }
    }
    static void triangle(int v){
        for (int i = v; i > 0; i--) {
            for (int j = i; j <= v; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static int sumofnumber(int n){
        if (n == 1){
            return 1;
        }
        else {
            return n + sumofnumber(n-1);
        }
    }
    static void reversetriangle(int v){
        for (int i = 0; i <= v; i++) {
            for (int j = i; j < v; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static int fibonacci(int n){
        if (n == 1){
            return 1;
        }
        else if(n == 0) {
            return 0;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    static float average(float ...arr){
        float a = arr[0]; // i am set first argument is total number of average
        float b = 0;
        for (float v: arr) {
            b += v;
        }
        b = b - a;
        return (b/a);
    }
    static void pattern1_rec(int v){
        if(v > 0){
            pattern1_rec(v-1); // nichhe ni loop max jetli var * print kar vanu hase e kari dese, pan eni pela ena thi 1 otheei var print kari dese, evij rite n-1 then n-1,....
            for (int j = 0; j < v; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern2_rec(int v){
        if(v > 0){
            for (int j = 0; j < v; j++) {
                System.out.print("*");
            }
            System.out.println();
            pattern2_rec(v-1);
        }
    }
    static float celsius_to_fahrenheit(float celsi){
        return (celsi * 9/5) + 32;
    }
    static int sumofnumber_using_loop(int n){
        int v=0;
        for (int i = 0; i <= n; i++) {
            v += i;
        }
        return v;
    }
    public static void main(String[] args) {
        //Q-1
        int n=8;
        multiplication(n);
        System.out.println();

        //Q-2
        int a = 8;
        triangle(a);
        System.out.println();

        //Q-3
        int b= sumofnumber(10);
        System.out.println("Sum of n Number is "+b);
        System.out.println();

        //Q-4
        reversetriangle(a);
        System.out.println();

        //Q-5
        int c = fibonacci(6); // 1 1 2 3 5 8
        System.out.println("Nth fibonacci number is "+c);
        System.out.println();

        //Q-6
        float d = average(5, 10, 20, 30, 40, 50);
        System.out.println("Average is "+d);
        System.out.println();

        //Q-7
        //Q-2 using recursion
        pattern1_rec(8);
        System.out.println();

        //Q-8
        //Q-4 using recursion
        pattern2_rec(8);
        System.out.println();

        //Q-9
        float celsius = 35;
        float fahrenheit = celsius_to_fahrenheit(celsius);
        System.out.println(celsius + "C = " + fahrenheit + "F");
        System.out.println();

        //Q-10
        //Q-3 using iterative (loops)
        int g = sumofnumber_using_loop(10);
        System.out.println("Sum of n Number using iterative is " + g);
        System.out.println();
    }
}
