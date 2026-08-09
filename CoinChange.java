// Time Complexity : O(n × amount)
// Space Complexity : O(n × amount)
// Did this code successfully run on Leetcode : Yes

// - Build a DP table where dp[i][j] = minimum coins needed to make amount j using first i coin types.
// - For each coin, either skip it: dp[i-1][j], or take it: dp[i][j-coin] + 1.
// - Take the minimum of both choices; if final value is amount + 1, return -1.



class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }

        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(coins[i - 1] > j) {
                    dp[i][j] = dp[i -1][j];
                    continue;
                }

                dp[i][j] = Math.min(
                        dp[i -1][j],
                        dp[i][j - coins[i - 1]] + 1
                );
            }
        }

        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}