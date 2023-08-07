package algoprep;

import java.util.Scanner;

public class Found_Intro_To_Problem_Solving_Floor_SQRTN {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int i = 1;
		int ans = 0;
		while (i * i <= n) {
			ans = i;
			i++;
		}
		System.out.println(ans);
		scanner.close();
	}
}
