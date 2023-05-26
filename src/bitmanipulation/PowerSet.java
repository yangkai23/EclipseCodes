package bitmanipulation;

public class PowerSet {
	public static void main(String[] args) {
		String st = "abc";
		int n = (int) Math.pow(2, st.length());
		for (int i = 1; i <= n; i++) {
			String val = String.format("%03d", Integer.parseInt(Integer.toBinaryString(i)));
//			System.out.println(val);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < val.length(); j++) {
				if (val.charAt(j) == '1')
					sb.append(st.charAt(j));
			}
			System.out.println(sb);
		}
	}

}
