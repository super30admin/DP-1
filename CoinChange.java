class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        int m=amount +1;
        int n=coins.length +1;
        
        int [][] dp=new int[n][m];
        
        //row
        
        for(int j=0;j< m;j++ )
        {
            dp[0][j]=99999;
            
        }
        
        //column
        for(int i=0;i< n ;i++)
        {
          dp[i][0]=0;   
        }
        
        for(int i=1; i< n;i++)
        {
            for(int j=1;j<m ;j++)
            {
                if (j < coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                    
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                    
                }
            }
        }
        return dp[n-1][m-1] == 99999 ? -1 : dp[n-1][m-1] ;
        
        
    }
}