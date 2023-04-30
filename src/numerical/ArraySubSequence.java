package numerical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySubSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		int x = getCount(n, A);
		System.out.println(x);
		sc.close();
	}

	public static int getCount(int N, List<Integer> A) {
		int k=N;
		int prod=1;
		while(k!=0) {
			prod=prod*2;
			k--;
		}
		return prod-1;
	}
}
