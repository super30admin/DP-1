// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i < n + 1; i += 1) {
            dp[0][i] = amount + 1;
        }

        for(int i = 1; i < m + 1; i += 1) {
            for(int j = 1; j < n + 1; j += 1) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[m][n] == amount + 1) {
            return -1;
        }
        return dp[m][n];
    }
}
