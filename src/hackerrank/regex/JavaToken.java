package hackerrank.regex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaToken {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		s = s.trim();
		s = s.replaceAll("[\\W_]{1,}", " ");
		StringTokenizer tokenizer = new StringTokenizer(s, " ");
		System.out.println(tokenizer.countTokens());
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
		/*
		 * String tokens[]=s.split("[\\W_ ]{1,}"); System.out.println(tokens[0]);
		 * System.out.println(Arrays.toString(tokens));
		 * System.out.println(tokens.length); for(String token:tokens) {
		 * System.out.println(token); }
		 */
		scan.close();
	}
}
