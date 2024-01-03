public class j080_try_catch {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c;
        // c = a/b; // not use try catch than this is showing error and program is exit
        // System.out.println("The result is " + c);
        try { // if try block doesn't run than run catch block
            c = a/b; // this is not a possible to any number divide by zero
            System.out.println("The result is " + c);
        }
        catch (Exception e){ // e is a variable, you can write any name, this is a store Exception
            System.out.println("We failed to divide. Reason:");
            System.out.println(e);
        }
    }
}
