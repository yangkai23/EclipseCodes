package recursion_basic;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("awesome"));
		System.out.println(isPalindrome("foobar"));
		System.out.println(isPalindrome("tacocat"));
		System.out.println(isPalindrome("amanaplanacanalpanama"));
	}

	public static boolean isPalindrome(String s) {
		if (s.length() == 1 || s.length() == 0)
			return true;
		if (!(s.charAt(0) == s.charAt(s.length() - 1)))
			return false;
		return isPalindrome(s.substring(1, s.length() - 1));
	}
}
