package out.production.Java_CWH;

class MyThreadRunnable1 implements Runnable { // runnable class is interface
    public void run() { // and run method is runnable interface method, then it is rec-vid to use this
                        // method, another this is showing error
        int i = 0;
        while (i < 1000) {
            System.out.println("I am a thread 1 runnable thread");
            i++;
        }
    }
}

class MyThreadRunnable2 implements Runnable {
    public void run() {
        int i = 0;
        while (i < 1000) {
            System.out.println("I am a thread 2 runnable thread");
            i++;
        }
    }
}

public class j071_thread_using_runnable {
    public static void main(String[] args) {
        MyThreadRunnable1 t1 = new MyThreadRunnable1();
        Thread th1 = new Thread(t1); // Thread constructor argumrnt is runnable interface object
                                     // and this is call run() method

        MyThreadRunnable2 t2 = new MyThreadRunnable2();
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();

        // ahi thodivar t1 object ni run() method and
        // thodivar t2 object ni run() method run thay chhe
    }
}
/*
 * HOW TO RUN THIS FILE ON TERMINAL
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH>
 * javac -d . src/j071_thread_using_runnable.java
 * PS D:\Happy_Coding\With_Github\MPC\Java_CWH>
 * java out/production/Java_CWH/j071_thread_using_runnable
 */