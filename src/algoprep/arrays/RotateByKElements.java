package algoprep.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RotateByKElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int ar[] = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = scanner.nextInt();
		}
		int k = scanner.nextInt();
		k = k % ar.length;
		reverse(0, k, ar);
		System.out.println(Arrays.toString(ar));
		reverse(k + 1, ar.length - 1, ar);
		System.out.println(Arrays.toString(ar));
		reverse(0, ar.length - 1, ar);
		System.out.println(Arrays.toString(ar));
		Arrays.stream(ar).forEach(i -> System.out.print(i + " "));
		scanner.close();
	}

	public static void reverse(int start, int end, int ar[]) {
		if (start < end && start >= 0 && end < ar.length) {
			while (start < end) {
				int temp = ar[start];
				ar[start] = ar[end];
				ar[end] = temp;
				start++;
				end--;
			}
		}
	}
}
