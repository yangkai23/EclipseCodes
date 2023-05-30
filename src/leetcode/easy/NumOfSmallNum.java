package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumOfSmallNum {
	public static void main(String[] args) {
		int nums[] = { 6, 5, 4, 8, 8 };
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		/*
		 * ArrayList<Integer> list = new ArrayList<>(); for (int i : nums) list.add(i);
		 * 
		 * Collections.sort(list); int result[] = new int[nums.length]; for (int i = 0;
		 * i < result.length; i++) { result[i] = list.indexOf(nums[i]); } return result;
		 */

		int[] buck = new int[101];
		for (int num : nums)
			buck[num] += 1;
		for (int i = 1; i < buck.length; i++)
			buck[i] += buck[i - 1];
		for (int i = 0; i < nums.length; i++)
			nums[i] = nums[i] == 0 ? 0 : buck[nums[i] - 1];
		return nums;
	}
}
