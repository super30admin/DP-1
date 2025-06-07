// Time Complexity : O(m * n), where m = number of coins, n = amount
// Space Complexity : O(m * n) for the 2D DP array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// dynamic programming used to the coin change problem.
// A 2D DP table is created where dp[i][j] represents the minimum number of coins needed to make amount j using the first i types of coins.
// If the current coin's denomination is greater than the target amount j, we skip it.//no choose case
// Otherwise, we take the minimum between excluding the coin or including it (1 + dp[i][j - coin value]).
// The final answer is in dp[m][n]; if it's still INF (99999), return -1 meaning not possible.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        //DP table
        int[][] dp = new int[m+1][n+1];

        //Populate 0th row to max
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 99999;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //If denomination of the coin is greater than the amount->invalid so just take up
                if(coins[i-1] > j){
                    //no choose case
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n] == 99999) return -1;
        return dp[m][n];
    }
}