package algoprep.strings;

import java.util.Scanner;

/**
 * @author U6070304
 *
 */
public class PalindromeCheck {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.println(isPalindrome(string));
		scanner.close();
	}

	private static boolean isPalindrome(String string) {
		string = string.trim().toLowerCase();
		char ch[] = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ch[ch.length - i - 1])
				return false;
		}
		return true;
	}
}
