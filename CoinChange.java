class Solution {
    public int coinChange(int[] coins, int amount) {
        
       int m = coins.length+1;
       int n = amount+1;
        int [][] dp =new int [m][n];
       
        for(int i =0;i<m;i++)
        {
            
            dp[i][0]=0;
        }
        
         for(int j =1;j<n;j++)
        {
            
            dp[0][j]=9999;
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                
                if(coins[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],(dp[i][j- coins[i-1]]+1));
                }
            }
            
        }
        return dp[m-1][n-1] == 9999 ? -1 : dp[m-1][n-1];
    }
    
}