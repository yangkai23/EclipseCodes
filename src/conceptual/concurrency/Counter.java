package conceptual.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Counter {
	/* volatile */ AtomicInteger count=new AtomicInteger(1);
//	volatile int count;
//	AtomicIntegerFieldUpdater<Counter> counter=AtomicIntegerFieldUpdater.newUpdater(Counter.class, "count");
	public void getCount() {
		for (int i = 1; i <= 10; i++)
			System.out.println(Thread.currentThread().getName()+"     "+count.getAndIncrement())/*er.getAndUpdate(this, (k->k+1)))*/;
	}
}