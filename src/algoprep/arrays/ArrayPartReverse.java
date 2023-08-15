package algoprep.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPartReverse {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		if (start < end && start >= 0 && end < ar.length) {
			while (start < end) {
				int temp = ar[start];
				ar[start] = ar[end];
				ar[end] = temp;
				start++;
				end--;
			}
			Arrays.stream(ar).forEach(i -> System.out.print(i + " "));
			scanner.close();
		}
	}
}
