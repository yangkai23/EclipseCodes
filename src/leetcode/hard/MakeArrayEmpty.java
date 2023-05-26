package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;

public class MakeArrayEmpty {
	public static void main(String[] args) {
		int[] nums = { -15, -19, 5 };
//		/* int min = */Arrays.stream(nums).skip(0).forEach(System.out::println);
//		System.out.println(min);
		System.out.println(countOperationsToEmptyArray(nums));
	}

	public static long countOperationsToEmptyArray(int[] nums) {
		HashMap<Integer, Integer> pos = new HashMap<>();
		long n = nums.length, res = n;
		for (int i = 0; i < n; i++)
			pos.put(nums[i], i);
		System.out.println(pos);
		Arrays.sort(nums);
		for (int i = 1; i < n; i++) {
			if (pos.get(nums[i]) < pos.get(nums[i - 1]))
				res += n - i;
		}
		return res;
		/*
		 * if (nums.length == 1) return 1; if (nums.length == 0) return 0; int
		 * numOperation = 0; for (int i = 1; i < nums.length; i++) { int currentPos = i
		 * - 1; int currentElement = nums[i]; while (currentPos >= 0 && nums[currentPos]
		 * > currentElement) { numOperation++; nums[currentPos + 1] = nums[currentPos];
		 * currentPos--; } nums[currentPos + 1] = currentElement; }
		 * System.out.println(Arrays.toString(nums)); return numOperation + nums.length;
		 */
	}

	/*
	 * public static long countOperationsToEmptyArray(LinkedList<Integer> nums, int
	 * operationCount) {
	 * 
	 * if (nums.size() == 1) { return operationCount + 1; } int min =
	 * Collections.min(nums);
	 * 
	 * if (nums.get(0) == min) { nums.remove(0); operationCount++;
	 * 
	 * } else { int temp = nums.remove(0); nums.add(temp); operationCount++; }
	 * return countOperationsToEmptyArray(nums, operationCount); }
	 */
}
