package algoprep.recursion;

import java.util.Scanner;

public class PalindromeRecursion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String val = scanner.next();
		boolean result = recurse(val, 0, val.length() - 1);
		System.out.println(result);
		scanner.close();
	}

	private static boolean recurse(String val, int i, int j) {
		if (val == null || val.trim().isEmpty())
			return false;
		if (i >= j)
			return true;
		if (val.charAt(i) != val.charAt(j))
			return false;
		return recurse(val, i++, j--);
	}

}
