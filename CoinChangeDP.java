// Time Complexity : O(mn) we are iterating through the entire matrix
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        
        int[][] dp = new int[coins.length +1][amount + 1];
        
        //filled the first row
        for(int j = 1; j <= amount; j++){
            dp[0][j] = amount + 1;
            
        }
        
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <=amount; j++){
                
                //current amount is less than denomination then we just take the min amount from the above row of the matrix
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }
                //choose, dont choose
                else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        
        return dp[coins.length][amount] == amount + 1? -1: dp[coins.length][amount];
    }
}