// Time -> O(n*m)
// Space -> O(n*m)
// Leetcode 322 - Coin change
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0; i<=amount; i++){
            dp[0][i] = amount+1;
        }
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        
        for(int row = 1; row<dp.length; row++){
            for(int col=1; col<dp[0].length; col++){
                
                if(col<coins[row-1]){
                    dp[row][col] = dp[row-1][col];
                }else{
                    dp[row][col] = Math.min(dp[row-1][col], 1+dp[row][col-coins[row-1]]);
                }
            }
        }
        
        if (dp[coins.length][amount] == amount +1){
            return -1;
        }
        
        return dp[coins.length][amount];
    }
}