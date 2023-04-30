package numerical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		int k = sc.nextInt();
		int x = maxPairs(n, A, k);
		System.out.println(x);
		sc.close();

	}

	private static int maxPairs(int N, List<Integer> A, int k) {
		int count = 0;
		boolean check[] = new boolean[A.size()];
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (!check[i] && !check[j]) {
					if (A.get(i) + A.get(j) >= k) {
						check[i] = true;
						check[j] = true;
					}
				}
			}
		}
		for (int i = 0; i < check.length; i++) {
			if (!check[i])
				count++;
		}
		return count;
	}
}
