package algoprep.hash;

import java.util.HashMap;
import java.util.Scanner;

public class FirstUniqueElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		System.out.println(findUniqueElement(ar));
		scanner.close();
	}

	private static int findUniqueElement(int[] ar) {
		HashMap<Integer, Integer> lhm = new HashMap<>();
		for (int i : ar) {
			lhm.put(i, lhm.getOrDefault(i, 0) + 1);
		}
		for (int num : ar) {
			if (lhm.get(num) == 1)
				return num;
		}
		return -1;
	}
}
