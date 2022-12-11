// Time Complexity : O(n)
// Space Complexity : O(amount * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        // Extra row and column for imaginary row and column
        int[][] dp = new int[coins.length + 1][amount+1];
        
        // 0 coins needed to make 0 money from 0 denomination
        dp[0][0] = 0;
        
        // Infinite number of coins to make different amounts from 0 denomination
        for(int j = 1; j < amount + 1; j++){
           dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < coins.length + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                // Until the denomination of the coin, case 1: don't choose. So the value is from                    upper row
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                // Minimum of privous row and choosing 1 coin + denomination times back.
                else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-coins[i-1]] + 1); 
                }
            }
        }
        
        if(dp[coins.length][amount] >= amount + 1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}