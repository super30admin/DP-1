package com.exmaple.problems;

import java.util.Arrays;

//Time Complexity : O(2^N) for Recursive Approach O(N) for DP 
//Space Complexity : Size of Recursive Stack  O(N) for DP
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
We have used DP to cache the result of recursive apporach to avoid re-computation 
*/

public class CoinChange {
	public static boolean isDP = false;

	public int helper(int coins[], int amount, int index, int min) {
		if (amount < 0 || index >= coins.length)
			return -1;
		if (amount == 0)
			return min;
		int case1 = helper(coins, amount, index + 1, min);
		int case2 = helper(coins, amount - coins[index], index, min + 1);
		if (case1 == -1)
			return case2;
		else if (case2 == -1)
			return case2;

		return Math.min(case1, case2);
	}

	public int dp(int coins[], int amount) {
		int dp[] = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = 9999999;
		}
		for (int coin : coins) {
			for (int j = 1; j <= amount; j++) {
				if (coin <= j) {
					dp[j] = Math.min(dp[j], dp[j - coin] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];

	}

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount < 0)
			return -1;
		if (!isDP)
			return helper(coins, amount, 0, 0);
		return dp(coins, amount);
	}

	public static void main(String args[]) {
		int coins[] = { 1, 2, 5 };
		int amount = 11;

		CoinChange coin = new CoinChange();

		System.out.println(coin.coinChange(coins, amount));
	}
}
