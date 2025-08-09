import java.util.*;

// Greedy-Exhaustive Approach
// This brute-force approach tries every possible combination of including or excluding each coin. It uses recursion to explore all paths, resulting in exponential time complexity.
// Time Complexity : O(2 ^ (number of coins × amount))
// Space Complexity : O(amount) -> recursive stack depth
// Did this code successfully run on Leetcode : No (TLE on large inputs)
// Any problem you faced while coding this : No

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int result = recursiveHelper(coins, 0, amount, 0);
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private int recursiveHelper(int[] coins, int i, int amount, int coinsUsed) {
        // base case: amount < 0 or end of coin list
        if (amount < 0 || i == coins.length) return Integer.MAX_VALUE;
        // base case: exact change achieved
        if (amount == 0) return coinsUsed;

        // case 0: skip current coin
        int case0 = recursiveHelper(coins, i + 1, amount, 0);
        // case 1: choose current coin
        int case1 = recursiveHelper(coins, i, amount - coins[i], coinsUsed + 1);

        // return min of both cases
        return Math.min(case0, case1);
    }
}

// 2D DP Approach
// Builds a DP table where dp[i][j] represents the minimum
// coins needed to make amount j using first i coins.
// Transitions depend on whether current coin is used or not.
// Time Complexity : O(m * n), where m = number of coins, n = amount
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange2DP {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        // base case: 0 coins to make amount 0
        dp[0][0] = 0;

        // fill first row with 'infinite' (unreachable state)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = amount + 1;
        }

        // build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    // can't pick the coin
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // min of excluding or including current coin
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        // result is at bottom-right of the table
        if (dp[m][n] == amount + 1) return -1;
        return dp[m][n];
    }
}

// 1D DP Optimized Approach
// Instead of a 2D table, we use a 1D array to track the
// minimum coins needed for each amount up to n.
// Transitions are same as 2D, just space optimized.
// Time Complexity : O(m * n), where m = number of coins, n = amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Inner loop indexing 

class CoinChage1DP {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] dp = new int[n + 1];
        
        // fill with high value to represent unreachable state
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // base case: 0 coins needed to make amount 0

        // loop over each coin
        for (int i = 0; i < coins.length; i++) {
            // update dp for all values from coin value up to amount
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
        }

        // return result or -1 if unreachable
        if (dp[n] == amount + 1) return -1;
        return dp[n];
    }
}
