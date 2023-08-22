package algoprep.hash;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSumHashMap {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int reqSum = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		findUniqueElement(ar, reqSum);
		scanner.close();
	}

	private static void findUniqueElement(int[] ar, int reqSum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : ar) {
			map.put(num, reqSum - num);
		}
		for (int num : ar) {
			int val = map.get(num);
			if (map.get(val) != null) {
				System.out.println('Y');
				return;
			}

		}
		System.out.println('N');
	}
}
