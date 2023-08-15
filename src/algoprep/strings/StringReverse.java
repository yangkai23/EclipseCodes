package algoprep.strings;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		System.out.println(reverse(string));
		scanner.close();
	}

	private static String reverse(String string) {
		char ch[] = string.toCharArray();
		for (int i = 0; i < ch.length / 2; i++) {
			char t = ch[i];
			ch[i] = ch[ch.length - i - 1];
			ch[ch.length - i - 1] = t;
		}
		return String.valueOf(ch);
	}
}
