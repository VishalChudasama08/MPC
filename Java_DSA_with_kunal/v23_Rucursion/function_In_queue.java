package v23_Rucursion;

public class function_In_queue {
    public static void main(String [] args){
        System.out.println(0);
        int n = 1;
        function1(n);
    }
    // debugger this file and see 'Threads & Variables' (in IntelliJ) here,
    // first main function is in Queue than that call function1, now in Queue add function1,
    // function1 call function2, function2 is added on queue,..... at last function5 add in queue,
    // function5 its work done than, function5 out of queue (remove from queue), than function4 done,....
    // out function4 then, function3 then function2,.... at last main function remove from queue than program is complete.

    private static void function1(int n) {
        System.out.println(n);
        function2(n+1);
    }
    private static void function2(int n) {
        System.out.println(n);
        function3(n+1);
    }
    private static void function3(int n) {
        System.out.println(n);
        function4(n+1);
    }
    private static void function4(int n) {
        System.out.println(n);
        function5(n+1);
    }
    private static void function5(int n) {
        System.out.println(n);
    }
}
