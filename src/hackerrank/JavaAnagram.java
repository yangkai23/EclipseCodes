package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class JavaAnagram {
	static boolean isAnagram(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		if (a.length() != b.length())
			return false;
		int[] alphabets1 = new int[26];
		int[] alphabets2 = new int[26];
		for (char c : a.toCharArray()) {
			alphabets1[(int) (c - 97)]++;
		}
		for (char c : b.toCharArray()) {
			alphabets2[(int) (c - 97)]++;
		}
		System.out.println(Arrays.toString(alphabets1));
		System.out.println(Arrays.toString(alphabets2));
		/*
		 * if (!(Arrays.compare(alphabets1, alphabets2) == 0)) return false;
		 */
		for (int i = 0; i < alphabets1.length; i++) {
			if (alphabets1[i] != alphabets2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
