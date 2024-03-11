class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int dp[][] = new int[n+1][m+1];
        for(int j=0; j<m+1; j++)
            dp[0][j] = amount + 1;
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        if(dp[n][m] == amount+1)
            return -1;
        return dp[n][m];


    }
}

// Time Complexity : O(n*m) where n is the length of coins array and m is the amount
// Space Complexity : O(n*m) where n is the length of coins array and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
