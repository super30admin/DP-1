// Time Complexity : O(NLogN) + O(NM)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Have trouble understanding the time complexity and the recursion tree

import java.util.Arrays;

public class Coin_Change {
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				} else {
					break;
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		int min_coins = coinChange(coins, amount);
		System.out.println("Coins: " + Arrays.toString(coins));
		System.out.println("Amount: " + amount);
		System.out.println("Minimum coins Used: " + min_coins);
	}
}