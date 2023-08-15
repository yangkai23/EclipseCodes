package algoprep.arrays._2d;

import java.util.Scanner;

public class RowWiseTraverse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		int ar[][] = new int[row][column];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = scanner.nextInt();
			}
		}
		readRowWise(ar);
		scanner.close();
	}

	public static void readRowWise(int ar[][]) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}
}
