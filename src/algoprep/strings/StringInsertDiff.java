package algoprep.strings;

import java.util.Scanner;

public class StringInsertDiff {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		System.out.println(insertDiff(string));
		scanner.close();
	}

	private static String insertDiff(String string) {
		char ch[] = string.toCharArray();
		StringBuilder res = new StringBuilder();
		res.append(ch[0]);
		for (int i = 1; i < ch.length; i++) {
			int diff =ch[i] - ch[i - 1];
			res.append(diff).append(ch[i]);
		}
		return res.toString();
	}

}
