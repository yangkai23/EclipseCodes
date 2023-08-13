package algoprep;

import java.util.Scanner;

public class AtleastOneGreaterArr {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int max = ar[0];
		int temp = max;
		int maxCount = 1;
		for (int i = 1; i < ar.length; i++) {
			max = Math.max(max, ar[i]);
			if (temp == ar[i]) {
				maxCount++;
			} else if (max > temp) {
				maxCount = 1;
			}
			temp = max;
		}
		System.out.println(max);
		System.out.println(maxCount);
		System.out.println(ar.length - maxCount);
		scanner.close();
	}
}
