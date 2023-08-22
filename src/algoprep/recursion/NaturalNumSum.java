package algoprep.recursion;

import java.util.Scanner;

public class NaturalNumSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(getSum(num));
		scanner.close();
	}

	private static int getSum(int num) {
		if (num == 1)
			return 1;
		int temp = getSum(num - 1);
		return temp + num;
	}
}
