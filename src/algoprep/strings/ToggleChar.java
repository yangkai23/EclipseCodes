package algoprep.strings;

import java.util.Scanner;

public class ToggleChar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		System.out.println(toggle(string));
		scanner.close();
	}

	public static String toggle(String string) {
		char ch[] = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (isUpperCase(ch[i]))
				ch[i] = (char) (ch[i] + 32);
			else
				ch[i] = (char) (ch[i] - 32);
		}
		return String.valueOf(ch);
	}

	public static boolean isUpperCase(char c) {
		return c >= 65 && c <= 90;
	}
}
