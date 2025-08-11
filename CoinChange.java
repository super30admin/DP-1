class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int m = coins.length + 1;
        int n = amount + 1;
        int dp[][] = new int[m][n];

/**
 *   0 1 2 3 4 5 6
 * 0 0 I I I
 * 1 0
 * 2 0
 * 5 0
 */
        for (int j = 1; j < n; ++j) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount] == amount + 1 ? -1: dp[coins.length][amount];
    }

}