package conceptual.concurrency.threads.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test implements Callable<String> {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 10; i++) {
			Future<String> future = executor.submit(new Test());
			String test = future.get(1L, TimeUnit.SECONDS);
			System.out.println(test);
		}

		executor.shutdown();
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return null;
	}
}
