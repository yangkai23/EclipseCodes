package algoprep.recursion;

import java.util.Scanner;

public class PowerCalculateRecursion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int val = scanner.nextInt();
		int pow = scanner.nextInt();
		int result = recurse(val, pow);
		System.out.println(result);
		scanner.close();
	}

	public static int recurse(int val, int pow) {
		if (pow == 1)
			return val;
		int temp = recurse(val, pow / 2);
		if ((pow & 1) == 0)
			return temp * temp;
		else
			return val * temp * temp;
	}
}
