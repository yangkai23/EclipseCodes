package algoprep.hash;

import java.util.HashMap;
import java.util.Scanner;

public class Frequency {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int numQueries = scanner.nextInt();
		int[] queries = new int[numQueries];
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		for (int i = 0; i < numQueries; i++) {
			queries[i] = scanner.nextInt();
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : ar) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i = 0; i < queries.length; i++) {
			System.out.println(map.containsKey(queries[i]) ? map.get(queries[i]) : Integer.valueOf(0));
		}
		scanner.close();
	}
}
