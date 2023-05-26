package leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class NumOfSmallNum {
	public static void main(String[] args) {
		int nums[] = { 8, 1, 2, 2, 3 };
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		Arrays.sort(nums);
		int result[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
//			result[i]=comare[]
		}
		return null;
	}
}
