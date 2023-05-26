package leetcode.easy;

public class ArrayIncAndDec {
	public static void main(String[] args) {
		String[] operations = { "++X", "++X", "X++" };
		System.out.println(finalValueAfterOperations(operations));
	}

	public static int finalValueAfterOperations(String[] operations) {
		int val = 0;
		for (String string : operations) {
			/*
			 * if (string.contains("++")) val++; else val--;
			 */
			if (string.charAt(1) == '+')
				val++;
			else
				val--;
		}
		return val;
	}
}
