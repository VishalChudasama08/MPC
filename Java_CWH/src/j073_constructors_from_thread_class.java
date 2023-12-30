// package out.production.Java_CWH;

class MyThrRun implements Runnable {
    public void run() {
        // MyThr class ni run() method override thay chhe tethi aa
        // run() method run thati nathi
        System.out.println("I am Runnable");
    }
}

class MyThr extends Thread {
    public MyThr(Runnable task, String name) {
        super(task, name); // thread class na constructor ne String argumrnt send kare chhe
    }

    @Override
    public void run() {
        System.out.println("I am not sad!☻");
    }
}

public class j073_constructors_from_thread_class {
    public static void main(String[] args) {
        MyThrRun r1 = new MyThrRun();
        MyThr t1 = new MyThr(r1, "Vishal");
        MyThr t2 = new MyThr(r1, "Darshan");
        // 1st argument is runnable object this run MyThrRun class run() method
        // 2nd argument is MyThr class constructor argumrnt and it is set thread class
        // string name using tread class constructor

        t1.start();
        t2.start();

        System.out.println("The id of the thread t1 is " + t1.threadId());
        // threadId() is thread class method and its use to get thread id
        System.out.println("The name of the thread t1 is " + t1.getName());
        // getName() is thread class method and its use to get name
        // this name is thread consrtuctor String argumrnt

        System.out.println("The id of the thread t2 is " + t2.threadId());
        System.out.println("The name of the thread t2 is " + t2.getName());
    }
}
