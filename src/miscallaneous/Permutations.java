package miscallaneous;

import java.util.Scanner;

public class Permutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		printPermutations(word, 0, word.length() - 1);
		sc.close();
	}

	public static void printPermutations(String word, int left, int right) {
		if (left == right) {
			System.out.println(word);
		} else {
			for (int i = left; i <= right; i++) {
				word = swap(word, left, i);
				printPermutations(word, left + 1, right);
				word = swap(word, left, i);
			}
		}
	}

	public static String swap(String word, int pos, int i) {
		StringBuilder sb = new StringBuilder(word);
		char poschar = sb.charAt(pos);
		char tobeReplaced = sb.charAt(i);
		sb.setCharAt(i, poschar);
		sb.setCharAt(pos, tobeReplaced);
		return sb.toString();
	}
}
