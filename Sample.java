import java.util.Arrays;

// Time Complexity : O(N)
// Space Complexity : O(N) for recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

/**
 * Based on the condition, we have two possibilities.
 * 1. Take the current value and skip the next one to jump to i+2th index.
 * 2. Ignore ith index and jump to i+1th index.
 * Take a dp array filled with -1 to store max value obtained till ith index.
 * Iterate from 0th index, see if dp[i] is already filled, that means dp[i]
 * already has highest value till i. If not -1, return dp[i] else take 
 * max(current index + i+2 to n index, i+1 to n index)
 * Whatever value is present in dp[n-1], that would be the highest value possible.
 */
class Sample {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		return helper(nums, dp, 0);
	}

	public int helper(int[] nums, int[] dp, int i) {
		if (i >= nums.length)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		dp[i] = Math.max(nums[i] + helper(nums, dp, i + 2), helper(nums, dp, i + 1));
		return dp[i];
	}
}