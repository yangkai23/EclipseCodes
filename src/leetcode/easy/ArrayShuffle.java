package leetcode.easy;

import java.util.Arrays;

public class ArrayShuffle {
	public static void main(String[] args) {
		int nums[] = new int[] { 1, 1, 2, 2 };
		int n = 2;
		System.out.println(Arrays.toString(shuffle(nums, n)));
	}

	public static int[] shuffle(int[] nums, int n) {
		int result[] = new int[nums.length];
		int i = 0, resPos = 0;
		while (i < n) {
			result[resPos++] = nums[i];
			result[resPos++] = nums[i + n];
			i++;
		}
		return result;
	}
}
