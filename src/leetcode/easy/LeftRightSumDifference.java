package leetcode.easy;

import java.util.Arrays;

public class LeftRightSumDifference {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(Arrays.toString(leftRigthDifference(nums)));
	}

	public static int[] leftRigthDifference(int[] nums) {
		int leftSum = 0;
		int rightSum = 0;
		int totalSum = 0;
		int[] result = new int[nums.length];
		for (int num : nums)
			totalSum += num;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0)
				leftSum += nums[i - 1];
			rightSum = totalSum - nums[i] - leftSum;
			result[i] = Math.abs(leftSum - rightSum);
		}
		return result;
	}

	/*
	 * 0 ms solution
	 * 
	 * public int[] leftRigthDifference(int[] nums) { int ans[]=new
	 * int[nums.length]; recursion(nums,ans,0,0,0); return ans; }
	 * 
	 * private static int recursion(int nums[],int ans[],int index,int rs,int ls){
	 * if(index>=nums.length){ return rs; } ans[index]=ls; ls=ls+nums[index];
	 * rs=recursion(nums,ans,index+1,rs,ls); ans[index]=Math.abs(ans[index]-rs);
	 * rs=rs+nums[index]; return rs; }
	 * 
	 */
}
