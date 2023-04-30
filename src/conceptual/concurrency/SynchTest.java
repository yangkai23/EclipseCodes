package conceptual.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class SynchTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		Counter counter=new Counter();
		MyThread thread1=new MyThread(counter);
		MyThread thread2=new MyThread(counter);
		thread1.start();
		thread2.start();
		ConcurrentHashMap<Integer, String> concurrentHashMap=new ConcurrentHashMap<>();
	}
	
}
