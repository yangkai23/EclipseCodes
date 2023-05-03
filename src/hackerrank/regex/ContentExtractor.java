package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentExtractor {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		// Write your code here
		String patternToMatch = "<(.+)>([^<]+)</\\1>";
		Pattern pattern = Pattern.compile(patternToMatch);
		Matcher matcher = pattern.matcher(line);
		boolean found = false;
		while (matcher.find()) {
			found = true;
			System.out.println(matcher.group(2));
		}
		if (!found)
			System.out.println("None");
		in.close();
	}
}
