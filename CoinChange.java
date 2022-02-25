// Time Complexity : O(n) where n is # coins * amount
// Space Complexity : O(n) where n is # coins * amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int inf = Integer.MAX_VALUE-1;
        
        int[][] dp = new int[n+1][amount+1];
        
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 1; j < amount+1; j++) {
            dp[0][j] = inf;
            
            // initializing 2nd row
            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            }
            else {
                dp[1][j] = inf;
            }
        }
        
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < amount+1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = Math.min(
                        1 + dp[i][j-coins[i-1]], 
                        dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if (dp[n][amount] == inf) {
            return -1;
        }
        return dp[n][amount];
    }
}