package gfg;

import java.util.Arrays;

public class LeftRotateArr {
	public static void main(String[] args) {
		int ar[] = { 7, 4, 6, 8 };
		int n = 2;
		System.out.println(Arrays.toString(shiftByN(ar, n)));
	}

	private static int[] shiftByN(int[] ar, int n) {
		reverse(ar, 0, n - 1);
		reverse(ar, n, ar.length - 1);
		reverse(ar, 0, ar.length - 1);
		return ar;
	}

	private static void reverse(int[] ar, int start, int end) {
		while (start <= end) {
			int temp = ar[start];
			ar[start++] = ar[end];
			ar[end--] = temp;
		}
	}

}
