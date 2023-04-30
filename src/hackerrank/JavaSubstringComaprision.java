package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JavaSubstringComaprision {
	public static String getSmallestAndLargest(String s, int k) {
		/*
		 * String smallest = ""; String largest = "";
		 * 
		 * // Complete the function // 'smallest' must be the lexicographically smallest
		 * substring of length 'k' // 'largest' must be the lexicographically largest
		 * substring of length 'k'
		 * 
		 * String temp1 = s.substring(0, k); int start = 0; int end = k; String temp2 =
		 * s.substring(start, end); while (start <= s.length() - k + 1 && end <
		 * s.length()) { temp1 = s.substring(start, end); System.out.println(start +
		 * "      " + end); if (end <= s.length()) { ++start; ++end; }
		 * System.out.println(start + "      " + end); temp2 = s.substring(start, end);
		 * System.out.println(temp1 + "     " + temp2); //
		 * System.out.println("small   "+smallest); int placement =
		 * temp2.compareTo(temp1); System.out.println(placement); if (placement > 0) {
		 * System.out.println("Hi"); if (temp1.compareTo(largest) > 0) largest = temp1;
		 * } else if (placement < 0) { if (temp2.compareTo(smallest) > 0) smallest =
		 * temp2; } if (start < s.length() - k - 1) { ++start; ++end; } }
		 */

		// ===============================================
		/*
		 * String smallest = s.substring(0, k); String largest = s.substring(0, k); for
		 * (int i = 1; i < s.length() - k + 1; i++) { if
		 * (smallest.compareTo(s.substring(i, i + k)) > 0) smallest = s.substring(i, i +
		 * k); if (largest.compareTo(s.substring(i, i + k)) < 0) largest =
		 * s.substring(i, i + k);
		 * 
		 * }
		 */
		// =========================================================
		List<String> list = new LinkedList<>();
		for (int i = 0; i < s.length() - k + 1; i++) {
			list.add(s.substring(i, i + k));
		}
		Collections.sort(list);
		System.out.println(list);
			return list.get(0) + "\n" + list.get(list.size()-1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
