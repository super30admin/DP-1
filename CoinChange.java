// Time Complexity : O(m * n)
//Space Complexity : O(m * n)   
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = amount + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] > j) {
                    // 0 case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int re = dp[m][n];
        if (re >= amount + 1)
            return -1;
        return re;
    }
}