package algoprep.hash;

import java.util.HashMap;
import java.util.Scanner;

public class NumOfRightAngleTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[][] = new int[size][2];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < 2; j++) {
				ar[i][j] = scanner.nextInt();
			}
		}
		System.out.println(getCount(ar));
		scanner.close();
	}

	private static int getCount(int[][] ar) {
		HashMap<Integer, Integer> Xpoints = new HashMap<>();
		HashMap<Integer, Integer> Ypoints = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			Xpoints.put(ar[i][0], Xpoints.getOrDefault(ar[i][0], 0) + 1);
			Ypoints.put(ar[i][1], Xpoints.getOrDefault(ar[i][1], 0) + 1);
		}
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (Xpoints.get(ar[i][0]) >= 1 && Ypoints.get(ar[i][1]) >= 1) {
				count += (Xpoints.get(ar[i][0]) - 1) * +(Ypoints.get(ar[i][1]) - 1);
			}
		}
		return count;
	}
}
