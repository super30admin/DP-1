// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        
        //create a dp matrix
        int[][] dp = new int[coins.length+1][amount+1];
        
        // fill first row with infinite value
        for(int j=1;j<amount+1;j++){
            dp[0][j] = amount+1;
        }
        
        //
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else{
                    //choose or don't choose
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }
            }
        }
        return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];  
    }
}