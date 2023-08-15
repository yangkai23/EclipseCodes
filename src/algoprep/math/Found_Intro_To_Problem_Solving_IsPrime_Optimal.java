package algoprep.math;

import java.util.Scanner;

public class Found_Intro_To_Problem_Solving_IsPrime_Optimal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (i != n / i)
					count += 2;
				else
					count += 1;
			}
		}
		if (count == 2)
			System.out.println("Yay");
		else
			System.out.println("Nay");
		scanner.close();
	}
}
