package recursion_basic;

import java.util.Scanner;

public interface Fibanocci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
//		System.out.println(getFibanoccinum(x));
		getAll(x, 0, 1);
		sc.close();

	}

	public static int getFibanoccinum(int x) {
		if (x < 0)
			return -1;
		if (x == 0 || x == 1)
			return x;
		return getFibanoccinum(x - 1) + getFibanoccinum(x - 2);
	}

	public static void getAll(int x, int p, int q) {
		if(x<0)
			System.out.println("num should be positive");
		if (q > x)
			return;
		System.out.print(p + " ");
		int sum = p + q;
		getAll(x, q, sum);
	}
}
