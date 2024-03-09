// Time Complexity : O(m*n) where 'm' is the amount and 'n' is the length of the coins.
// Space Complexity : O(m*n) where 'm' is the amount and 'n' is the length of the coins.
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/coin-change/
// Any problem you faced while coding this : In this we have used Bottom up DP implementation i.e. tabulation.


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1]; // because one row and one column is extra. We have taken 0 as a dummy node.
        //first row
        for(int j=1;j<=m;j++){
            dp[0][j] = amount+1; // infinity
        }

        for(int i=1;i<dp.length;i++){ // It will be the denomination of the coin
            for(int j=1;j<dp[0].length;j++){ // The amount will be the columns
                // amount is smaller than denomination of coin
               if(j<coins[i-1]){ // i-1 is done because array starts from 0
               // case 0
               dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
            }
         }
        }
        if(dp[n][m]>amount) return -1;
         return dp[n][m];
    }
}
