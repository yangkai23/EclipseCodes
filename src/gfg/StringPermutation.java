package gfg;

public class StringPermutation {
	public static void main(String[] args) {
		printPermutations("ABCD");
	}

	public static void printPermutations(String s) {
		printPermutations(s, 0);
	}

	public static void printPermutations(String s, int i) {
		if (i == s.length() - 1) {
			System.out.println(s);
			return;
		}
		for (int j = i; j < s.length(); j++) {
//			System.out.println(s + "  " + i + "    " + j);
			s = swap(s, i, j);
			printPermutations(s, i + 1);
			s = swap(s, j, i);
		}
	}

	public static String swap(String s, int i, int j) {
		StringBuilder builder = new StringBuilder(s);
		char atI = s.charAt(i);
		builder.setCharAt(i, s.charAt(j));
		builder.setCharAt(j, atI);
		return builder.toString();
	}
}
