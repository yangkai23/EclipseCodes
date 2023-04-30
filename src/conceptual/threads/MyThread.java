package conceptual.threads;

public class MyThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread.work());
        Thread thread1 = new Thread(myThread.work());
        thread.setName("Thread1");
        thread1.setName("Thread2");
        thread.start();
        thread1.start();
    }

    public Runnable work() {
        return () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "     " + i);
                    if (Thread.currentThread().getName().equals("thread1") && i == 6) Thread.yield();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };

    }
}
