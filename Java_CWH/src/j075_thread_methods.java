class MyThread3 extends Thread{
    public void run(){
        int i  = 0;
        while(i <= 100){
            System.out.println("This is Thread 3");
            try {
                Thread.sleep(100); // 100-millisecond sleep than run, continue...,
                // this time run other code like other threads, ...
                // sleep() method throwing exception use on try catch
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            i++;
        }
    }
}
class MyThread4 extends Thread{
    public void run(){
        int i  = 0;
        while(i <= 100){
            System.out.println("This is Thread 4");
            i++;
        }
    }
}
public class j075_thread_methods {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3();
        MyThread4 t2 = new MyThread4();
        t1.start();
        try{
            t1.join(); // join() method use to join thread, in this line first run t1 and then run t2
            // join() method use on try catch, because join() method throwing exception
        }
        catch (Exception e){
            System.out.println(e);
        }
        t2.start();
    }
}
