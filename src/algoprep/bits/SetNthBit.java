package algoprep.bits;

import java.util.Scanner;

public class SetNthBit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int res = 1 << k;
		System.out.println(getBinaryNum(res));
		System.out.println(getBinaryNum(res | n));
		System.out.println(res | n);
		scanner.close();
	}

	public static int getBinaryNum(int num) {
		return Integer.parseInt(Integer.toBinaryString(num));
	}
}
