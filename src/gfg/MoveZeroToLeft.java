package gfg;

import java.util.Arrays;

public class MoveZeroToLeft {
	public static void main(String[] args) {
		int ar[] = { 0, 0, 3, 0, 4, 5 };
		System.out.println(Arrays.toString(moveZeroes(ar)));
	}

	private static int[] moveZeroes(int[] ar) {
		/*
		 * int lastNonZeroPos = -1; for (int i = 0; i < ar.length; i++) { if (ar[i] !=
		 * 0) { if (lastNonZeroPos == -1) { if (ar[0] == 0) { ar[0] = ar[i]; ar[i] = 0;
		 * lastNonZeroPos = 0; } }
		 * 
		 * else if (lastNonZeroPos != i) { ar[lastNonZeroPos + 1] = ar[i]; ar[i] = 0;
		 * lastNonZeroPos += 1; } } }
		 */
		int nZP = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != 0) {
				ar[nZP++] = ar[i];
				ar[i] = 0;
			}

		}
		return ar;
	}
}
