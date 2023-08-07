package algoprep;

import java.util.Scanner;

public class LargestTwice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];

		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (max == ar[i]) {
				count++;
				continue;
			} else if (ar[i] > max) {
				count = 1;
				max = ar[i];
			}
		}

		if (max != Integer.MIN_VALUE) {
			if (count > 1) {
				System.out.println(true);
				scanner.close();
				return;
			}
		}
		System.out.println(-1);
		scanner.close();
	}
}
