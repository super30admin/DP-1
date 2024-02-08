// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the logic behind the tabulation

class Solution {

    public int coinChange(int[] coins, int amount) {
        int m = amount; // row
        int n = coins.length; // column

        int[][] dp = new int[n + 1][m + 1];

        // Amount is 0 and coins are 0
        dp[0][0] = 0;

        // Coins are 0 so amount cannot be achieved
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 99999;
        }

        // Bottom Up Approach - Tabulation
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }

        int result = dp[n][m];
        if (result >= 99999) {
            return -1;
        }

        return result;
    }
}