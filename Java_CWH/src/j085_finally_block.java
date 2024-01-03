public class j085_finally_block {
    public static int greet(int a){
        try{
            int b = 50/a;
            return b;
        }
        catch (Exception e){
            System.out.println(e);
        }
        // use finally with try block and catch block
        // finally run is finally
        // if method return, if loop break, any ... but finally block is run
        finally {
            System.out.println("I am finally block");
        }return 0;
    }
    public static void main(String[] args) {
        int c = greet(2);
        System.out.println(c);
        int d = 10;
        while(true){
            try {
                System.out.println(c/d);
            }
            catch (Exception e){
                System.out.println(e);
                break;
            }
            finally { // if loop is break on line 27 but this finally block is run
                System.out.println("I am finally block, value of b is: " + d);
            }
            d--;
        }
    }
}
