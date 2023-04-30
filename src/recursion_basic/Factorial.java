package recursion_basic;

import java.util.Scanner;

public interface Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int res = getFactorial(n);
//		System.out.println(res);
		int arr[] = { 1, 2, 3, 4, 5 };
		System.out.println(productofArray(arr, arr.length));
		sc.close();
	}

	public static int getFactorial(int n) {
		if (n < 0)
			return -1;
		if (n == 0 || n == 1)
			return 1;
		return n * getFactorial(n - 1);
	}

	public static int productofArray(int A[], int N) {
		if (N == 1)
			return 1;
		int x = N - 1;
		return A[x] * productofArray(A, N - 1);
	}
}
