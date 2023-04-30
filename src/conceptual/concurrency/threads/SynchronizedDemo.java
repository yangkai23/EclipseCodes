package conceptual.concurrency.threads;

import java.util.Calendar;
import java.util.Date;

public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        Thread t1 = new Thread(demo.work());
        Thread t2 = new Thread(demo.work());
        t1.setName("Thread1");
        t2.setName("Thread2");
        t1.start();
        t2.start();


    }

    public Runnable work() {
        return () -> {
            for (int i = 1; i <= 10; i++) {
                getDate(Thread.currentThread().getName() , i);
                System.out.println(Thread.currentThread().getName() + "~~~~~~~" + i);
            }
        };
    }

    public synchronized void getDate(String name,int i) {
        if(name.contentEquals("Thread2") && i==7){

            System.out.println("sync problem");
            return;
        }
        System.out.println(Calendar.DATE);
    }
}
