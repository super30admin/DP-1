// Time Complexity : O(m*n) , m=amount, n=total elements in coins array
// Space Complexity : O(m*n), m=amount, n=total elements in coins array
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        
        //initializing the first row with amount+1, value larger than amount
        for(int i=1; i<=amount; i++)
            dp[0][i] = amount+1;
        
        for(int i=1; i<=coins.length; i++) 
            for(int j=1; j<=amount; j++) 
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
        
        return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
    }
}