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
		if(string==null||string.isBlank() || string.isEmpty())
			return false;
		char ch[] = string.toCharArray();
		for (int i = 0; i < ch.length / 2; i++) {
			char t = ch[i];
			ch[i] = ch[ch.length - i - 1];
			ch[ch.length - i - 1] = t;
		}
		return String.valueOf(ch).equals(string);
	}
}
