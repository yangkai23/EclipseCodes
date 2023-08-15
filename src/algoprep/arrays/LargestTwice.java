package algoprep.arrays;

import java.util.Scanner;

public class LargestTwice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];

		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		System.out.println(dominantIndex(ar));
		scanner.close();
	}

	public static int dominantIndex(int[] arr) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		int second = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				second = max;
				max = arr[i];
				index = i;
			} else if (arr[i] > second)
				second = arr[i];
		}
		return second * 2 <= max ? index : -1;
	}

}
