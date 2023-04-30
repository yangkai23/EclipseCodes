package numerical;

import java.util.Scanner;

public class HappyNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(isHappyNumber(num));
		scanner.close();
	}

	public static String isHappyNumber(int num) {
		while (num > 9) {
			int sum = 0;
			do {
				int d = num % 10;
				sum += (int) Math.pow(d, 2);
				num /= 10;
			} while (num != 0);
			num = sum;
		}
		if (num == 1 || num == 7)
			return "Happy Number";
		return "Not a Happy Number";
	}
}