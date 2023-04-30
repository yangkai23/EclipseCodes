package conceptual.concurrency.synchronize;

public class Main extends Thread {

	Task task;

	public Main(Task task) {
		this.task = task;
	}

	@Override
	public void run() {
		task.getTask();
	}

	/*
	 * public void checkEvenOdd(int i) { if ((i & 1) == 0) System.out.println(i +
	 * " is even"); else System.out.println(i + " is odd"); }
	 */

}
