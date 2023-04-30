package numerical;

import java.util.Scanner;

public class FibanocciPlusDivisors {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number for series to stop");
		int limit = scanner.nextInt();
		getFibanocciWithDivisors(limit);
		scanner.close();
	}

	private static void getFibanocciWithDivisors(int limit) {
		int ar[] = new int[limit];
		ar[0] = 0;
		printDivisors(ar[0]);
		ar[1] = 1;
		printDivisors(ar[1]);
		for (int i = 2; i < ar.length; i++) {
			ar[i] = ar[i - 1] + ar[i - 2];
			printDivisors(ar[i]);
		}
	}

	public static void printDivisors(int num) {
		if (num == 0) {
			System.out.println(num + " Divisors : infinite Divisors");
			return;
		}
		System.out.print(num + " Divisors :  ");
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				System.out.print(i + "  ");
		}
		System.out.println("" + num);
	}
}
