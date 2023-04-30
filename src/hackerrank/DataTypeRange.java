package hackerrank;

import java.util.Scanner;

public class DataTypeRange {
	public static void main(String[] argh) {

		Scanner scanner = new Scanner(System.in);
		/*
		 * int t = sc.nextInt();
		 * 
		 * for (int i = 0; i < t; i++) {
		 * 
		 * try { long x = sc.nextLong(); System.out.println(x + " can be fitted in:");
		 * if (x >= -128 && x <= 127) System.out.println("* byte");
		 * 
		 * if (x >= Math.pow(-2, 15) && x <= Math.pow(2, 15) - 1)
		 * System.out.println("* short"); if (x >= Math.pow(-2, 31) && x <= Math.pow(2,
		 * 31) - 1) System.out.println("* int"); if (x >= Math.pow(-2, 63) && x <=
		 * Math.pow(2, 63)-1) { System.out.println("* long"); }
		 * 
		 * 
		 * if (x >= -32768 && x <= 32767) System.out.println("* short"); if (x >=
		 * Math.pow(-2, 31) && x <= Math.pow(2, 31) - 1) System.out.println("* int"); if
		 * (x >= Math.pow(-2, 63) && x <= Math.pow(2, 63) - 1) {
		 * System.out.println(Math.pow(2, 63) - 1); System.out.println("* long"); }
		 * 
		 * 
		 * } catch (Exception e) { System.out.println(sc.next() +
		 * " can't be fitted anywhere."); }
		 * 
		 * }
		 */
		int breadth = scanner.nextInt();
		int height = scanner.nextInt();
		if (breadth <= 0 || height <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
			scanner.close();
			return;
		}
		System.out.println(breadth * height);
		scanner.close();
	}
}
