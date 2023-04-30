package recursion_basic;

import java.util.Arrays;

public class CapitalizeWord {
	public static String capitalizeWord(String str) {
		if (str.length() == 0)
			return "";
		String list[] = str.split(" ");
		System.out.println(Arrays.toString(list));
		String s = "";
		for (int i = 1; i < list.length; i++) {
			s = s + list[i] + " ";
		}
		return Character.toUpperCase(list[0].charAt(0)) + list[0].substring(1, list[0].length())
				+" "+ capitalizeWord(s.trim());
	}

	public static void main(String[] args) {
		String st = capitalizeWord("i love you");
		System.out.println(st);
	}
}
