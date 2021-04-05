// Time Complexity : O( Coin * Amount)
// Space Complexity : O( Coin * Amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int j = 1 ; j < amount+1 ; j++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1 ; i < coins.length+1; i++){
            int coin = coins[i-1];
            
            for(int j = 1 ; j < amount + 1 ; j++){
                if (coin > j){
                    dp[i][j] = dp[i-1][j];    
                }else{
                    dp[i][j] = Math.min(dp[i][j-coin]+1,dp[i-1][j]);
                }
                
            }
                
            
        }
        if(dp[coins.length][amount] == amount + 1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}
