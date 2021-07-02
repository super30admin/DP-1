// 322. Coin Change - https://leetcode.com/problems/coin-change/
// Time Complexity : O(M)(N)
// Space Complexity : O(M)(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        // filled first row
        for(int j=1;j<=amount;j++)
        {
            dp[0][j] = amount+1;
        }
        
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount; j++)
            {
                // current amount < denomination
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                // choose, don't choose
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        
        return dp[coins.length][amount] ==  amount+1? -1:dp[coins.length][amount];
    }
}