// Time Complexity : O(coints.length * amount)
// Space Complexity : O(coints.length * amount)
// Did this code successfully run on Leetcode : yes, used DP approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int [coins.length+1][amount+1];
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 99999;
        }
        for(int i=1; i<dp.length;i++){
            for(int j=1; j<dp[0].length; j++){
                if(j<coins[i-1]) 
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]= Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);    
                }
            }
        }
        if(dp[coins.length][amount] >= 99999) return -1;
        return dp[coins.length][amount];
    }
}