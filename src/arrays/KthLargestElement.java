package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nums[] = new int[scanner.nextInt()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = scanner.nextInt();
		int k = scanner.nextInt();
		System.out.println(getKthLargestElement(nums, k));
		scanner.close();
	}

	private static int getKthLargestElement(int[] nums, int k) {
		sort(nums);
		System.out.println(Arrays.toString(nums));
		if (k == 1)
			return nums[0];
		if (k > nums.length)
			return 0;
		int kthLarget = 0;
		int count = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			count++;
			if (count == k) {
				kthLarget = nums[i];
				break;
			}
			while (nums[i] == nums[i - 1] && i > 0)
				i--;

		}
		return kthLarget;
	}

	public static int[] sort(int[] ar) {
		for (int i = 1; i < ar.length; i++) {
			int current = ar[i];
			int index = i;
			while (index > 0 && ar[index - 1] > current) {
				ar[index] = ar[index - 1];
				index--;
			}
			ar[index] = current;
		}
		return ar;
	}
}
