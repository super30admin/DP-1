// Time Complexity : O(m*n) m-coins, n-amount
// Space Complexity : O(m*n) DP matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach:
// Used a 2D DP matrix with rows as coins and columns as amount.
// Choose and no choose cases considered for each coin selected by comparing previous result and current coin change.
// Return the number of coins from last cell if required amount is formed, else return -1. 


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;

        int[][] dp=new int[m+1][n+1];
        
        for(int j=1;j<=n;j++){
            dp[0][j]=99999;
        }

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n]==99999) return -1;
        return dp[m][n];
    }
}



// Time Complexity : O(m * n) m-coins, n-amount
// Space Complexity : O(n) 1D DP array
// Did this code successfully run on Leetcode : Yes

// Approach:
// Initialize a 1D DP array where dp[j] is the minimum coins needed for amount j.
// For each coin, update the DP array by checking if choosing the coin gives a better result.
// Return dp[n] if amount achievable, otherwise return -1 for impossible cases.


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;

        int[] dp=new int[n+1];
        
        for(int j=1;j<=n;j++){
            dp[j]=99999;
        }

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    dp[j]=dp[j];
                }
                else{
                    dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
                }
            }
        }
        if(dp[n]==99999) return -1;
        return dp[n];
    }
}