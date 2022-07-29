// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use Memoization to compute the number of coins needed as we can rely on previously computed sub problems than re compute it every single time


class Solution {
    public int coinChange(int[] coins, int amount) {
        // O(m*n)
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        // top row
        for(int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // till amount is not equal to denomination
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[m][n];
        if(result > amount) {
            return -1;
        }
        return result;
    }
}