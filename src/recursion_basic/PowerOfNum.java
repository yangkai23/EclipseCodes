package recursion_basic;

import java.util.Scanner;

public interface PowerOfNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int pow = sc.nextInt();
		double res = getValue(x, pow, false);
		System.out.println(res);
		sc.close();
	}

	public static double getValue(double x, double y, boolean check) {
		if (y < 0) {
			check = !check;
			y = y * -1;
		}
		if (y == 0)
			return 1;
		if (check)
			return (double) (1 / x * getValue(x, y - 1, check));
		return x * getValue(x, y - 1, check);
	}
}
