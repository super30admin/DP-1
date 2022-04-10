// Time complexity: O(m*n) where m is the number of coins and n is the amount.
// Space complexity: O(m*n) where m is the number of coins and n is the amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < amount + 1; i++) {       // Initialization of 1st row(Zero).
            dp[0][i] = amount + 1;                  // Equivalent to Integer max value.
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) {                  // If coin is less than the amount.
                    dp[i][j] = dp[i - 1][j];            // Take the above row value.
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);     // Take minimum of the coins used.
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1) return -1;
        return dp[coins.length][amount];
    } 
}