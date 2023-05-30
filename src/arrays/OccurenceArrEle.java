package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class OccurenceArrEle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nums[] = new int[scanner.nextInt()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = scanner.nextInt();
		printOccurences(nums);
		scanner.close();
	}

	private static void printOccurences(int[] nums) {
		sort(nums);
		int len = nums[nums.length - 1];
		int occurences[] = new int[len + 1];
		for (int i = 0; i < nums.length; i++) {
			occurences[nums[i]]++;
		}
		System.out.println(Arrays.toString(occurences));
		for (int i = 0; i < occurences.length; i++) {
			if (occurences[i] == 0)
				continue;
			System.out.println(i + " : " + occurences[i]);
		}
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
