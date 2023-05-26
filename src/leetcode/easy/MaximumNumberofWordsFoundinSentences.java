package leetcode.easy;

import java.util.StringTokenizer;

public class MaximumNumberofWordsFoundinSentences {
	/*
	 * public static void main(String[] args) { StringTokenizer stringTokenizer =
	 * new StringTokenizer("Hi my name is");
	 * System.out.println(stringTokenizer.countTokens());
	 */

	public int mostWordsFound(String[] sentences) {
		if (sentences.length == 0)
			return 0;
		int max = 0;
		for (String st : sentences) {
			if (st == null)
				continue;
			StringTokenizer stringTokenizer = new StringTokenizer(st);
			if (stringTokenizer.countTokens() > max)
				max = stringTokenizer.countTokens();
		}
		return max;
	}
}
