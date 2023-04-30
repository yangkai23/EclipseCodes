package algorecall;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ar[] = new int[scanner.nextInt()];
		for (int i = 0; i < ar.length; i++)
			ar[i] = scanner.nextInt();
		mergeSort(ar);
		scanner.close();
	}

	private static void mergeSort(int[] ar) {
		divide(ar, 0, ar.length);
		System.out.println(Arrays.toString(ar));
	}

	public static void divide(int ar[], int start, int end) {
		if (end - start < 2)
			return;
		int mid = (start + end) / 2;
		divide(ar, start, mid);
		divide(ar, mid, end);
		merge(ar, start, mid, end);
	}

	private static void merge(int[] ar, int start, int mid, int end) {
		if (ar[mid - 1] <= ar[mid])
			return;
		int left = start;
		int right = mid;
		int newArray[] = new int[end - start];
		int newArrPosition = 0;
		while (left < mid && right < end) {
			newArray[newArrPosition++] = ar[left] > ar[right] ? ar[right++] : ar[left++];
		}
		System.arraycopy(ar, left, ar, start + newArrPosition, mid - left);
		System.arraycopy(newArray, 0, ar, start, newArrPosition);
	}
}
