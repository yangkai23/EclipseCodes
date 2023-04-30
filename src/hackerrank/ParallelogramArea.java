package hackerrank;

import java.util.Scanner;

public class ParallelogramArea {
	public static void main(String[] argh) {

		Scanner scanner = new Scanner(System.in);
		int breadth = scanner.nextInt();
		int height = scanner.nextInt();
		if (breadth <= 0 || height <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
			scanner.close();
			return;
		}
		System.out.println(breadth * height);
		scanner.close();
	}
}
