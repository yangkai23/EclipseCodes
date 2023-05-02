package hackerrank.regex;

import java.util.Scanner;

public class IPAddessValidate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String IP = in.next();
		System.out.println(IP.matches(new MyRegex().pattern));
		in.close();
	}
}

class MyRegex {
	{
		String pat = "(\\d{1,2}|(0|1)\\d{1,2}|2[0-4]\\d|25[0-5])";
		String dot = "\\.";
		pattern = pat + dot + pat + dot + pat + dot + pat;
	}
	String pattern;
}
