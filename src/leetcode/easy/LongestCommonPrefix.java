package leetcode.easy;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] words = { "abc", "ab", "a" };
		System.out.println(longestCommonPrefix(words));
	}

	public static String longestCommonPrefix(String[] strs) {

		int start = 0;
		int end = 1;
		int position = 1;
		StringBuilder longestPrefix = new StringBuilder("");
		String checkWord = strs[0];
		if (checkWord.length() == 0)
			return longestPrefix.toString();
		if (strs.length == 1)
			return strs[0];
		boolean containsEveryString = false;

		outer: while (end <= checkWord.length()) {
			String prefix = checkWord.substring(start, end);
			while (position < strs.length) {
				if (strs[position].length() == 0)
					return longestPrefix.toString();
				if (prefix.length() > strs[position].length())
					return longestPrefix.toString();
				if (strs[position].substring(start, end).contentEquals(prefix)) {
					containsEveryString = true;
				} else {
					containsEveryString = false;
					break outer;
				}
				position++;
			}
			if (containsEveryString)
				longestPrefix.replace(0, longestPrefix.length(), prefix);
			position = 1;
			end++;
		}
		return longestPrefix.toString();
//0ms solution 
		/*
		 * if (strs == null || strs.length == 0) return ""; String pre = strs[0]; int i
		 * = 1; while (i < strs.length) { while (strs[i].indexOf(pre) != 0) pre =
		 * pre.substring(0, pre.length() - 1); i++; } return pre;
		 */
	}
}
