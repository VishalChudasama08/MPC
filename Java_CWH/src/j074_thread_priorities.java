class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    public void run(){
        int i = 0;
        while (i <= 100){
            System.out.println("I Am Thread" + getName());
            i++;
        }
    }
}
public class j074_thread_priorities {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("1");
        MyThread t2 = new MyThread("2");
        MyThread t3 = new MyThread("3");
        MyThread t4 = new MyThread("3");
        // Priority out of 10, default all threads sem priority it is 5
        t1.setPriority(Thread.MIN_PRIORITY); // MIN_PRIORITY = 1/10
        t2.setPriority(Thread.NORM_PRIORITY); // NORM_PRIORITY = 5/10
        t3.setPriority(8); // 8/10
        System.out.println(t3.getPriority()); // get priority value
        t4.setPriority(Thread.MAX_PRIORITY); // MAX_PRIORITY = 10/10
        // maximum priority object thread maximum run time and minimum priority thread minimum run time
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
