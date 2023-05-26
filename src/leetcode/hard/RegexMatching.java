package leetcode.hard;

/*import java.util.regex.Matcher;
import java.util.regex.Pattern;*/

public class RegexMatching {

	public static void main(String[] args) {
		String s = "aab", p = "c*a*b";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
		/*
		 * Pattern pattern = Pattern.compile(p); Matcher matcher = pattern.matcher(s);
		 * 
		 * if (matcher.matches()) { matchCount++; } System.out.println(matchCount); if
		 * (matchCount != 1) return false;
		 * 
		 * return matcher.matches();
		 */
		/*
		 * int matchPos = 0; int patPos = 0; p = p.trim(); s = s.trim(); if
		 * (p.equals(".*")) return true; if (p.equals(".")) return s.length() == 1;
		 * while (matchPos < s.length() && patPos < p.length()) {
		 * 
		 * if (p.charAt(patPos) != '*' || p.charAt(patPos) != '.') { if
		 * (p.charAt(patPos) == s.charAt(matchPos)) { matchPos++; patPos++; } else {
		 * return false; }
		 * 
		 * } else { if (p.charAt(patPos) == '.' && p.charAt(patPos + 1) == '*' && patPos
		 * + 1 == p.length() - 1) return true; if (p.charAt(patPos) == '.' &&
		 * p.charAt(patPos + 1) != '*') { patPos++; matchPos++; } if (p.charAt(patPos)
		 * == '*') { char prev = s.charAt(matchPos); patPos++; while (prev ==
		 * s.charAt(matchPos - 1)) matchPos++; } } }
		 */
		if (p.equals(".*"))
			return true;
		if (p.equals("."))
			return s.length() == 1;
		int patPos = 0;
		while (patPos < p.length() && s.indexOf("" + p.charAt(patPos)) != -1)
			patPos++;
		if (patPos == 0)
			return false;
		char c = s.charAt(patPos - 1);
		int matchPos = patPos;
		System.out.println(matchPos);
		System.out.println(patPos);
		while (matchPos < s.length() && patPos < p.length()) {
			System.out.println("Hi");
			if (p.charAt(patPos) == '*') {
				while (matchPos < s.length() && s.charAt(matchPos) == c)
					matchPos++;
				System.out.println(matchPos);
			} else if (p.charAt(patPos) == '.') {
				if (patPos != p.length() - 1) {
					if (p.charAt(patPos + 1) == '*' && patPos + 1 == p.length() - 1)
						return true;
					else {
						while (s.charAt(matchPos) != p.charAt(patPos + 2) && matchPos < s.length())
							matchPos++;
						if (matchPos == s.length())
							return false;
					}
				}
				matchPos++;
				patPos++;
			}
			if (matchPos == s.length())
				return true;
			patPos++;

		}
		return false;
	}
}
