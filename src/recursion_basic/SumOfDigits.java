package recursion_basic;

import java.util.Scanner;

public interface SumOfDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = getSum(n);
		System.out.println(res);
		sc.close();
	}

	public static int getSum(int n) {
		if (n == 0)
			return 0;
		return n % 10 + getSum(n / 10);
	}
}
