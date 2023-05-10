package leetcode.easy;

public class ArrayConcat {
	public static void main(String[] args) {
		int[] input = { 1, 2, 1 };
		getConcatenation(input);
	}

	public static int[] getConcatenation(int[] nums) {
		int[] resultArray = new int[nums.length * 2];
		System.arraycopy(nums, 0, resultArray, 0, nums.length);
		System.arraycopy(nums, 0, resultArray, nums.length, resultArray.length - nums.length);
		return resultArray;
	}
}
