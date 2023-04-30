package conceptual.concurrency;

public class MyThread extends Thread {
	Counter counter;

	public MyThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.getCount();
	}
}
