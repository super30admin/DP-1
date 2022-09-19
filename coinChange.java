class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        dp[0][0]=0;
        for(int i=1;i<amount+1;i++)
            dp[0][i]=amount+1;
        
        for(int i=1;i<n+1;i++)
            dp[i][0]=0;
        
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
        
        return (dp[n][amount]>amount)?-1:dp[n][amount];
    }
}

// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no