package recursion_basic;

import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
//		int res = getGcd(a, b, 1, 0);
		int res = getGcd(a, b);
		System.out.println(res);
		sc.close();
	}

	@SuppressWarnings("unused")
	private static int getGcd(int a, int b, int x, int max) {
		if (x > a || x > b)
			return max;
		if (a % x == 0 && b % x == 0) {
			if (x > max)
				max = x;
		}
		return getGcd(a, b, x + 1, max);
	}

	public static int getGcd(int a, int b) {
		if (a < 0 || b < 0)
			return -1;
		if (b == 0)
			return a;
		return getGcd(b, a % b);
	}
}
