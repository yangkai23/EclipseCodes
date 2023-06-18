package leetcode.medim;

import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		boolean indexMark[] = new boolean[nums.length];
		threeSum(nums, 0, 1, 2, list, indexMark);
		return list;
	}

	private static void threeSum(int[] nums, int i, int j, int k, List<List<Integer>> list, boolean[] indexMark) {
		if (i == nums.length || j == nums.length || k == nums.length)
			return;
		if (nums[i] + nums[j] + nums[k] == 0 && !indexMark[i] && !indexMark[j] && !indexMark[k]) {
			List<Integer> tripletList = new LinkedList<>();
			tripletList.add(nums[i]);
			tripletList.add(nums[j]);
			tripletList.add(nums[k]);
			indexMark[i]=true;	indexMark[j]=true;	indexMark[k]=true;
			list.add(tripletList);
		}

		threeSum(nums, i + 1, j, k, list, indexMark);
		threeSum(nums, i, j + 1, k, list, indexMark);
		threeSum(nums, i, j, k + 1, list, indexMark);
	}

}
