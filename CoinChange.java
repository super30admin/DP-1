class coinChange {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int m= amount;
        int [] dp = new int[m+1];
        
        for(int i=0;i<=m;i++)
        {
            dp[0][i] = 99999;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(j< coins[i-1])
                {
                    dp[j] = dp[j];
                }
                else{
                dp[j] = Math.min(dp[j],1+dp[j-coins[i-1]]);
                }
            }
        }
       int res = dp[n][m];
       if(res>=99999)
       return -1;
       return res;
    }
}

//tc: O(m*n)
//tc: O(m);