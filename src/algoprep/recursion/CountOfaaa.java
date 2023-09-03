package algoprep.recursion;

import java.util.Scanner;

public class CountOfaaa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String val = scanner.next();
		System.out.println(count1(val, 0, 0));
		System.out.println(count2(val, 0, 0));
		scanner.close();
	}

	private static int count1(String val, int pos, int count) {
		if (pos >= val.length() - 2)
			return count;
		if (val.charAt(pos) == 'a' && val.charAt(pos) == val.charAt(pos + 1)
				&& val.charAt(pos) == val.charAt(pos + 2)) {
			int temp = count1(val, pos + 1, count + 1);
			return temp;
		} else {
			int temp = count1(val, pos + 1, count);
			return temp;
		}

	}

	private static int count2(String val, int pos, int count) {
		if (pos >= val.length() - 2)
			return count;
		if (val.charAt(pos) == 'a' && val.charAt(pos) == val.charAt(pos + 1)
				&& val.charAt(pos) == val.charAt(pos + 2)) {
			int temp = count2(val, pos + 3, count + 1);
			return temp;
		} else {
			int temp = count2(val, pos + 1, count);
			return temp;
		}
	}
}
