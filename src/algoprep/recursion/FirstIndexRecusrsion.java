package algoprep.recursion;

import java.util.Scanner;

public class FirstIndexRecusrsion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[scanner.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int ans = findIndex(arr, 0, m);
		System.out.println(ans);
		scanner.close();
	}

	private static int findIndex(int[] arr, int i, int m) {
		if (i >= arr.length) {
			return -1;
		}
		if (arr[i] == m)
			return i;
		else
			return findIndex(arr, i + 1, m);
	}
}
