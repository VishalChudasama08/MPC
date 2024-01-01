class P13Thread1 extends Thread{
    public void run(){
        int i  = 0;
        while(i <= 200) {
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Good Morning");
            i++;
        }
    }
}
class P13Thread2 extends Thread{
    public void run(){
        int i  = 0;
        while(i <= 200) {
            System.out.println("Welcome");
            i++;
        }
    }
}
public class j076_practice_set_13 {
    public static void main(String[] args) {
        //Q-1
        P13Thread1 p1 = new P13Thread1();
        P13Thread2 p2 = new P13Thread2();

        p1.setPriority(8);
        p2.setPriority(6);

        System.out.println("Thread1 " + p1.getPriority());
        System.out.println("Thread2 " + p2.getPriority());

        System.out.println("Before start Thread2 is " + p2.getState());
        p1.start();
        p2.start();
        System.out.println("After start Thread2 is " + p2.getState());

        //Q-2
        // use sleep() method on P13Thread1
        // this question cover on P13Thread1 class

        //Q-3
        // setPriority();
        // getPriority();
        // this question cover on q-1

        //Q-4
        // getState();
        // this question cover on q-1

        //Q-5
        // currentThread();
        System.out.println("Current Thread is " + Thread.currentThread().getState());
        // if you get more detail than see oracle.com java document 
    }
}
