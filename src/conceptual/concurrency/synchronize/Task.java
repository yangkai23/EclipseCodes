package conceptual.concurrency.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {
	volatile int count;
	Lock lock = new ReentrantLock();
	public void getTask() {
		
		lock.lock();
		try {
			
			for (int i = 1; i <= 20; i++) {
				System.out.println(Thread.currentThread().getName());
				incrementcount(i);
			}
		}

		finally {
			lock.unlock();
		}
	}

	public void incrementcount(int i) {
		synchronized (this) {
			count++;

			System.out.println("   count : " + count);
		}

//		checkEvenOdd(i);

	}
}