// Time Complexity : O(n * m)  n represents the number of coins available and m is the given amount
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// recursively explores two scenarios: including the current coin and excluding it.
import java.util.Arrays;

class problem1 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount + 1];
        for (long[] row : dp)
            Arrays.fill(row, -1);
        long result = countMinCoins(coins, n - 1, amount, dp);
        return result >= Integer.MAX_VALUE ? -1 : (int) result;
    }

    static long countMinCoins(int[] coins, int ind, int amount, long[][] dp) {
        if (amount == 0)
            return 0;

        if (ind < 0 || amount < 0)
            return Integer.MAX_VALUE;

        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        long include = 1 + countMinCoins(coins, ind, amount - coins[ind], dp);
        long exclude = countMinCoins(coins, ind - 1, amount, dp);

        return dp[ind][amount] = Math.min(include, exclude);
    }
}