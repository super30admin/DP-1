// Time Complexity : O(m*n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j=1; j< dp[0].length ; j++){
            dp[0][j] = 99999;
        }
        for(int i=1; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                 if(j<coins[i-1]){
                     dp[i][j] = dp[i-1][j];
                 }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n]>= 99999) return -1;
        else return dp[m][n];
    }
}