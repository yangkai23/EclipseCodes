package algoprep.recursion;

import java.util.Scanner;

public class FibanocciRecursion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(getNum(num));
		scanner.close();
	}

	private static int getNum(int num) {
		if (num == 0 || num == 1)
			return num;
		return getNum(num - 1) + getNum(num - 2);
	}
}
