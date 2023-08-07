package algoprep;

import java.util.Scanner;

public class AlgoPrep_Found_Pattern_HW {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int spaces = n - 1;
		int num = 1;
		int val = 0;
		int decCount = 0;
		for (int i = 1; i <= n; i++) {
			if (decCount != 0) {
				val -= 2;
			}
			for (int j = 1; j <= spaces; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= num; j++) {

				if (j <= (num / 2) + 1)
					val++;
				else
					val--;
				System.out.print(val);
				if (j < num)
					System.out.print(" ");
			}
			if (i <= n / 2) {
				num += 2;
				spaces -= 2;
			} else {
				decCount++;
				num -= 2;
				spaces += 2;
			}
			System.out.println();
		}

		scanner.close();
	}
}
