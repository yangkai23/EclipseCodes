package algoprep.hash;

import java.util.HashSet;
import java.util.Scanner;

public class UniqPointsCartesian {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar1[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar1[i] = scanner.nextInt();
		}
		int ar2[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar2[i] = scanner.nextInt();
		}
		System.out.println(findUniquePointsCount(ar1, ar2));
		scanner.close();
	}

	private static int findUniquePointsCount(int[] ar1, int[] ar2) {
		HashSet<String> hashSet = new HashSet<>();
		for (int i = 0; i < ar1.length; i++) {
			hashSet.add(ar1[i] + " " + ar2[i]);
		}
		return hashSet.size();
	}
}
