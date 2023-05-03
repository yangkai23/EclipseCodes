package hackerrank.regex;

import java.util.Scanner;

public class UsernameValidation {
	public static String regularExpression;
	static {
		regularExpression = "^[a-zA-Z][\\w_]{7,29}$";
	}
	public static void main(String[] args) {

	}
}

class Solution {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String userName = scan.nextLine();

		if (userName.matches(UsernameValidation.regularExpression)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}
}