package com.exmaple.problems;

import java.util.Arrays;

//Time Complexity : O(2^N) for Recursive Approach O(N) for DP
//Space Complexity : Size of Recursive Stack  O(N) for DP,O(1) for Top Down Approach
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
We have used DP to cache the result of recursive apporach to avoid re-computation 
*/

public class HouseRobber {

	private static boolean useMatrix = true;

	public int helper1(int nums[]) {
		int dp[] = new int[nums.length + 1];

		dp[0] = nums[0];
		dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		System.out.print(Arrays.toString(dp));
		return dp[nums.length - 1];
	}

	public int helper2(int nums[]) {
		int size = nums.length;
		int dp[][] = new int[size + 1][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
				} else if (j == 1) {
					dp[i][1] = dp[i - 1][0] + nums[i];
				}
			}
		}
		return Math.max(dp[size - 1][0], dp[size - 1][1]);
	}

	public int helper3(int nums[]) {
		int size = nums.length;
		int dp[][] = new int[size + 1][2];
		dp[0][0] = 0;
		dp[0][1] = nums[0];
		for (int i = 1; i < size; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = dp[i - 1][0] + nums[i];
		}
		System.out.println(Arrays.deepToString(dp));
		return Math.max(dp[size - 1][0], dp[size - 1][1]);
	}

	public int helper4(int nums[]) {
		int chosen = 0, notChosen = 0;
		for (int num : nums) {
			int temp = num;
			chosen = notChosen + num;
			notChosen = Math.max(notChosen, temp);
		}
		return Math.max(chosen, notChosen);
	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (!useMatrix) {
			return helper4(nums);
		}
		return helper2(nums);
	}

	public static void main(String args[]) {
		HouseRobber robber = new HouseRobber();

		int house[] = { 1, 2, 3, 1 };
		System.out.println(robber.rob(house));
	}
}
