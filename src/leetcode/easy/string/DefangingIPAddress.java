package leetcode.easy.string;

public class DefangingIPAddress {
	public static void main(String[] args) {
		System.out.println(defangIPaddr("255.100.50.0"));
	}

	public static String defangIPaddr(String address) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < address.length(); i++) {
			if (address.charAt(i) == '.') {
				builder.append("[.]");
				continue;
			}
			builder.append(address.charAt(i));
		}
		return builder.toString();
	}
}
