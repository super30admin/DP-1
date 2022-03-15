class Solution {
    public int coinChange(int[] coins, int amount) {
     
        int m = coins.length;
        int n = amount;
        
        int dp[][] = new int[m+1][n+1];
        
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][j] = amount+1;
        }
        
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(coins[i-1] > j)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = dp[dp.length-1][dp[dp.length-1].length-1];
        
        if(result>amount)
        {
            return -1;
        }
        
        return result;
    }
}