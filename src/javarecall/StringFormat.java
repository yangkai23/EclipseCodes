package javarecall;

import java.util.Formatter;

public class StringFormat {
	public static void main(String[] args) {
		/*
		 * float n = 10f; Formatter format = new Formatter();
		 * format.format("%d x %d = %f  \n", (int) n, (int) n, n = n / 3); n=32;
		 * System.out.printf("round off value is %#x", (int)n);
		 */
		int n = 2000, x = 2;
		System.out.printf("num is %06d", n);
		System.out.println();
		System.out.printf("num is %06d", x);
	}
}
