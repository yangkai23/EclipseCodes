package leetcode.easy;

import java.util.Arrays;
//import java.util.concurrent.atomic.AtomicInteger;

public class ArrayBuildFromPermutation {
	public static void main(String[] args) {
		int[] nums = { 5, 0, 1, 2, 3, 4 };
		System.out.println(Arrays.toString(buildArray(nums)));
	}

	public static int[] buildArray(int[] nums) {
		int newArr[] = new int[nums.length];
		/*
		 * AtomicInteger atomicInteger = new AtomicInteger(0); Arrays.stream(nums).map(i
		 * -> nums[i]).forEach(i -> { newArr[atomicInteger.getAndIncrement()] = i; });
		 */
		for (int i = 0; i < nums.length; i++)
			newArr[i] = nums[nums[i]];
		return newArr;
	}

}
