package cps.grants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelTasks {
	private final Collection<Runnable> tasks = new ArrayList<Runnable>();

	public void add(final Runnable task) {
		tasks.add(task);
	}

	public void go() throws InterruptedException {
		final ExecutorService threads = Executors.newFixedThreadPool(12);
		try {
			final CountDownLatch latch = new CountDownLatch(tasks.size());
			for (final Runnable task : tasks)
				threads.execute(new Runnable() {
					public void run() {
						try {
							task.run();
						} finally {
							latch.countDown();
						}
					}
				});
			latch.await();
		} finally {
			threads.shutdown();
		}
	}

	public int getTasksCount() {
		return tasks.size();
	}

}
