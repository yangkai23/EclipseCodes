package numerical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayProdSubSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		List<Integer> A = new ArrayList<>();
		List<Integer> R = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			R.add(sc.nextInt());
		}
		int res = NumberOfSubsequences(n, d, A, R);
		System.out.println(res);
		sc.close();
	}

	public static int NumberOfSubsequences(int N, int D, List<Integer> A, List<Integer> R) {
		int count = 0, i = 0, j = 0;
		while (i < N) {
			System.out.println("i "+A.get(i));
			if (A.get(i) == D) 
				count++;
			System.out.println("c1 "+count);
			int prod=A.get(i);
			while (j < N) {
				System.out.println("j  "+R.get(j));
				if(A.get(i)<R.get(j))
					continue;
					prod=prod*R.get(j);
					System.out.println("prod  "+prod);
					if(equalsZero(prod))
						count++;
					j++;
			}
			i++;
		}
		return count;
	}

	public static boolean equalsZero(int x) {
		return x % 10 == 0;
	}
}
