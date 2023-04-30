package numerical;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int sum = getSum(n);
		System.out.println(sum);
		scanner.close();
	}
	private static int getSum(int n) {
		int sum = 0;
		for (int i = n; i != 0; i = i / 10) {
			System.out.println("B "+i);
			sum = sum + i % 10;
			System.out.println("A "+i);
		}
		return sum;
	}

}
