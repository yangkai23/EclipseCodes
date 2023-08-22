package algoprep.hash;

import java.util.HashSet;
import java.util.Scanner;

public class NumOfUniqElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		System.out.println(findUniqueElements(ar));
		scanner.close();
	}

	private static int findUniqueElements(int[] ar) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : ar) {
			set.add(num);
		}
		return set.size();
	}
}
