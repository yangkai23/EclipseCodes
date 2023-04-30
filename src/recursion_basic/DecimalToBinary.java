package recursion_basic;

import java.util.Scanner;

public interface DecimalToBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//	int res=getBinary(n);
//	int res=revNum(n);
		int res = revRecursion(n,0);
		System.out.println(res);
		sc.close();
	}

	public static String getBinaryNumber(int n) {
		if (n == 0)
			return "";
		return n % 2 + " " + getBinaryNumber(n / 2).trim();
	}

	public static int getBinary(int n) {
		if (n == 0)
			return 0;
		System.out.println(n);
		return n % 2 + 10 * getBinary(n / 2);
	}

	public static int revNum(int n) {
		int sum = 0;
		while (n != 0) {
			int d = n % 10;
			sum = sum * 10 + d;
			n = n / 10;
		}
		return sum;
	}

	public static int revRecursion(int n,int sum) {
		if (n == 0)
			return sum;
//		System.out.println(n);
		sum=sum*10+n%10;
		return revRecursion(n/10,sum);
	}
}
