package algoprep.recursion;

import java.util.Scanner;

public class PrintNumRecusrion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(printNum(num));
		scanner.close();
	}

	private static int printNum(int num) {
		if (num == 1)
			return 1;
		System.out.println(num);
		return printNum(num - 1);
	}
}
