// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Take dp matrix of size coins and amount with + 1 added to each.
 * First row will be filled with max value because with 0 coins, we cannot
 * make any amount. dp[0][0] will be 0 as no coins needed for this sum.
 * first column is 0 because for 0 amount no coins are needed. Now,
 * Iterating over each coin and amount, at each index, we check which is
 * minimum: the no. of coins used till then excluding it or adding + 1 to the 
 * coins used after deducting the amount from the current amount. dp[coins][amount]
 * will be the final answer.
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		int m = coins.length;
		int[][] dp = new int[m + 1][amount + 1];
		dp[0][0] = 0;
		for (int i = 1; i < dp[0].length; i++)
			dp[0][i] = amount + 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				}
			}
		}
		return dp[m][amount] <= amount ? dp[m][amount] : -1;
	}
}
