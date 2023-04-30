package patterns;

import java.util.Scanner;

public class PyramidPattern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		pyramidWithFor(n);
		scanner.close();
	}

	private static void pyramidWithFor(int n) {
		int spaceCount1 = n / 2;
		spaceCount1 *= 2;
		int initial;
		if ((n & 1) == 0)
			initial = 2;
		else
			initial = 1;
		for (int i = initial; i < n; i += 2) {
			if (i != 1)
				spaceCount1 -= 2;
			for (int k = 1; k <= spaceCount1; k++)
				System.out.print(" ");

			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		int spaceCount = 0;
		for (int i = n; i >= 1; i -= 2) {
			if (i != n) {
				spaceCount += 2;
				for (int k = 1; k <= spaceCount; k++)
					System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
