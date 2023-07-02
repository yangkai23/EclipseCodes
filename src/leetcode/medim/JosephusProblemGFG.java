package leetcode.medim;

public class JosephusProblemGFG {
	public static void main(String[] args) {
		System.out.println(getKilled(6, 5));
	}

	public static int findTheWinner(int n, int k) {
		return getKilled(n, k) + 1;
	}

	public static int getKilled(int n, int k) {
		if (n == 1)
			return 0;
		else
			return (findTheWinner(n - 1, k) + k) % n;
	}
}
