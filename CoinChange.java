// Time Complexity : O(m*n) where m=no. of coins, n= amount
// Space Complexity : O(m*n) where m=no. of coins, n= amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = amount + 1; // the first row of max values, can include Integer.MAXVALUE
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < coins[i - 1]) { // the coin value in the table, not the exact array index.
                    dp[i][j] = dp[i - 1][j]; // 0 case
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // 1 case
                }
            }
        }

        if (dp[m][n] == amount + 1) {
            return -1;
        }

        return dp[m][n]; // last cell has the output
    }
}