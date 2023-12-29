class MyThread1 extends Thread { // Thread is java class
    @Override
    public void run() { // run() is prejent on Thread class
        int i = 0;
        while (i < 1000) {
            System.out.println("My Cooking Thread is Running");
            i++;
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 1000) {
            // System.out.println("Thread 2 for Chatting with her");
            System.out.println("I am sad!");
            i++;
        }
    }
}

public class j070_thread_by_extending_thread_class {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start(); // start() method presject on Thread class, on thread use than use it first and
                    // this method call run() method
        t2.start();
    }
}
