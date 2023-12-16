public class j033_variable_arguments {
    static int sum(int ...arr){ // use ...variable (...arr) to set multiple arguments it is store on array
        int values = 0;
        for(int v: arr){
            values += v;
        }
        return values;
    }
    static int minus(int x,int ...arr){ // set to 1 argument rec-vested,  use ... to set multiple arguments it is store in array
        int values = x;
        for(int v: arr){
            values -= v;
        }
        return values;
    }
    public static void main(String[] args) {
        int a = sum();
        int b = sum(8);
        int c = sum(5, 7);
        int d = sum(4, 6, 8);
        System.out.println("sum of nothing is :" + a);
        System.out.println("sum of 8 is :" + b);
        System.out.println("sum of 5 and 7 is :" + c);
        System.out.println("sum of 2, 6 and 8 is :" + d);

        int f = minus(3000, 900,98);
        System.out.println("minus of 900 and 98 in 3000 is : "+f);
    }
}
