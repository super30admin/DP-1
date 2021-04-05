// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null)
            return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Fill the first row(0-Coins) with a maximum amount value
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // If the coin value is greater than the amount fill it with waht we saw for
                // previous denominations
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Find min of previous denominations and the current one
                    dp[i][j] = Math.min(dp[i - 1][j], (dp[i][j - coins[i - 1]]) + 1);
                }

            }

            if (dp[dp.length - 1][dp[0].length - 1] == amount + 1)
                return -1;
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}