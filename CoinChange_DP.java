//Time: coins * amount
//Space: coins * amount
//Leetcode: https://leetcode.com/submissions/detail/614452182/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        //initialize first row
        for(int i = 1; i <= amount; i++) {
            dp[0][i] = amount +1;
        }
        
        //Initialize first column
        for(int i = 0; i <= coins.length; i++) {
           dp[i][0] = 0;
        }        
        
        for(int row = 1; row <= coins.length; row++) {
            for(int column = 1; column <= amount; column++) {
                
                //if amount is less than new denomination coming in.
                if(column < coins[row - 1]) {
                    dp[row][column] = dp[row - 1][column];
                } else {
         dp[row][column] = Math.min(dp[row - 1][column], (dp[row][column - coins[row - 1]]) + 1); 
                }
                                
            }
        }
        
        return dp[coins.length][amount] == amount + 1 ? -1 : dp[coins.length][amount];
    }
}