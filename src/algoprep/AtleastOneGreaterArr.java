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
		int maxCount = 0;
		for (int i = 1; i < ar.length; i++) {
			if (max == ar[i]) {
				maxCount++;
				continue;
			}
			if (ar[i] > max) {
				max = ar[i];
				maxCount = 1;
			}

		}
		System.out.println(maxCount);
		scanner.close();
	}
}
