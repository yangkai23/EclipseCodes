package algoprep;

import java.util.Scanner;

public class MaxDifference {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < ar.length; i++) {
			max = Math.max(max, ar[i]);
			min = Math.min(min, ar[i]);
		}
		System.out.println(max - min + ar.length - 1);
		scanner.close();
	}

	

}
