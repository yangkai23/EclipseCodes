package numerical;

public class LogBaseConv {
	public static void main(String[] args) {
		int n = 15;
		int k = 20;
		getSum(n, k);
	}

	public static int getSum(int n, int k) {
		int base10val = (int) Math.log10(n);
		int basekval = (int) (Math.log(base10val) / Math.log(k));
		int sum = 0;
		while (basekval != 0) {
			sum += basekval % 10;
			basekval /= 10;
		}
		return sum;

	}
}
