// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int cols = amount + 1;
        int rows = coins.length + 1;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < cols; j++) {
            dp[0][j] = 10000; //max amount = 10000;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
            }
        }

        return dp[rows - 1][cols - 1] == 10000 ? -1 : dp[rows - 1][cols - 1];
    }
}