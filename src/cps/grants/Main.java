package cps.grants;

public class Main {
	public static void main(String[] args) {
		ParallelTasks tasks = new ParallelTasks();
		RePackagingTask packagingTask = new RePackagingTask(
				"C:\\cps\\provider_setup\\PLoS\\scraping\\File\\2023-02-03\\pone",
				"C:\\cps\\provider_setup\\PLoS\\scraping\\File");
		tasks.add(packagingTask);
		try {
			tasks.go();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
