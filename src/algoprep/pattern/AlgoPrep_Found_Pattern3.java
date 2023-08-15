package algoprep.pattern;

import java.util.Scanner;

public class AlgoPrep_Found_Pattern3 {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int spaces = n / 2;
		int stars = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("*");
			}
			if (i <= n / 2) {
				stars += 2;
				spaces -= 1;
			} else {
				stars -= 2;
				spaces += 1;
			}
			System.out.println();
		}
		scanner.close();
	}
}
