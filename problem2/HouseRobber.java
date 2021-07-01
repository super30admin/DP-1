// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package problem2;

public class HouseRobber {
	/*
	 * The robber can either choose to rob the current house, or not. If he chooses
	 * to rob the current house, dp[i] = dp[i+2] + nums[i].\ Else, dp[i] = dp[i+1].
	 * To maximize, we need to find the maximum value of the above two.
	 */
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}

		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			dp[i] = nums[i];
		}

		for (int i = n - 2; i >= 0; i--) {
			dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
		}

		return Math.max(dp[0], dp[1]);
	}

	public static void main(String[] args) {
		HouseRobber obj = new HouseRobber();
		System.out.println("Maximum amount of money the robber can rob: " + obj.rob(new int[] { 1, 2, 3, 4, 7, 1 }));
	}
}
