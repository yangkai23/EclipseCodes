package algoprep.recursion;

import java.util.Scanner;

public class SortedCheckRecursion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[scanner.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}

		boolean ans = isSorted(arr, 1);
		System.out.println(ans);
		scanner.close();
	}

	private static boolean isSorted(int[] arr, int i) {
		if (i >= arr.length) {
			return true;
		}
		if (arr[i] < arr[i - 1]) {
			return false;
		} else
			return isSorted(arr, i+1);
	}
}
