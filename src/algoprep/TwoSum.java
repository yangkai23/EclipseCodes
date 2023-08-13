package algoprep;

import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int req = scanner.nextInt();
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[i] + ar[j] == req) {
					System.out.println("true");
					scanner.close();
					return;
				}
			}
			System.out.println("false");
		}

		scanner.close();
	}
}
