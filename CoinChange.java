/*
Author: Akhilesh Borgaonkar
Problem: LC 322. Coin Change (DP-1)
Approach: Using Dynamic Programming approach here to find the pattern of repeating sub-problems. 
Time Complexity: O(m*n) where m is number of coins and n is amount
Space complexity: O(1) constant
LC verified
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int r = dp.length;
        int c = dp[0].length;
        
        for(int i=0; i<r; i++)
            dp[i][0]=0;
        
        for(int j=1; j<c; j++)
            dp[0][j]=99999;
        
        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                if(j < coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
            }
        }
        int result = dp[coins.length][amount];
        if(result >= 99999)
            return -1;
        return result;
    }
}