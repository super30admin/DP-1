// Time Complexity :O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Uses a bottom-up(tabulation) approach.
// Maintains a dp[] array which stores the minimum number of coins required to make the amount.
// At every step, we have two choices: to pick the coin or not to pick. 

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE - 10;// to avoid overflow
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {//if value of coin is greater than amount
                    dp[j] = dp[j]; // keep the existing number
                } else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i - 1]]);//choose minimum of both options
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE - 10) return -1;
        return dp[amount];
    }
}

