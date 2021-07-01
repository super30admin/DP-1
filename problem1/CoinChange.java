// Time Complexity : O(n*n) : n -> size of array
// Space Complexity : O(amount*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package problem1;

import java.util.Arrays;

public class CoinChange {
	/*
	 * Dynamic Programming. We start with 1 coin, and check number of coins required
	 * to make up amounts from 0 to amount. We either choose the current coin, or
	 * not.
	 */
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount == 0) {
			return 0;
		}

		int[][] dp = new int[coins.length + 1][amount + 1];

		Arrays.sort(coins);

		for (int i = 0; i <= coins.length; i++) {
			dp[i][0] = 0;
		}

		for (int j = 0; j <= amount; j++) {
			dp[0][j] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
				}
			}
		}
		return dp[coins.length][amount] != Integer.MAX_VALUE - 1 ? dp[coins.length][amount] : -1;
	}

	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		System.out.println("Min coins required = " + obj.coinChange(new int[] { 1, 2, 5 }, 11));
	}

}
