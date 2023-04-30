package conceptual.concurrency.synchronize;

public class Test {
public static void main(String[] args) {
	Task task=new Task();
	Main t1=new Main(task);
	Main t2=new Main(task);
	t1.start();
	t2.start();
}
}
