package algoprep;

import java.util.Scanner;

public class MaxDifference2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int max1 = maxdifference_1(ar);
		System.out.println(max1);
		scanner.close();
	}

	public static int maxdifference_1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + i;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return max - min;
	}

}
