package miscallaneous;

import java.util.Scanner;

public class BooleanTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		if (!scanner.nextBoolean()) {
			System.out.println("false");
		}
		scanner.close();
	}
}
