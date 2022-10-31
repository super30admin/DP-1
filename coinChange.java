// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

// Your code here along with comments explaining your approach

class Solution {
	public int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0)
			return -1;

		int m = coins.length;
		int n = amount;

		int[][] dp = new int[m + 1][n + 1];

		dp[0][0] = 0;

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = n + 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}

		int res = dp[m][n];
		if (res > amount) {
			return -1;
		}

		return res;

		// return helper(coins, amount, 0, 0);
	}

	// Recursive solution
	private int helper(int[] coins, int amount, int idx, int min) {
		// base
		if (amount < 0 || coins.length == idx)
			return -1;
		if (amount == 0)
			return min;

		// logic

		// choose
		int case1 = helper(coins, amount - coins[idx], idx, min + 1);

		// not choose
		int case0 = helper(coins, amount, idx + 1, min);

		if (case1 == -1)
			return case0;
		if (case0 == -1)
			return case1;

		return Math.min(case0, case1);
	}

}