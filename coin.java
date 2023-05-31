class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        
        if(amount==0)
        {
            return 0;
        }

        for (int i = 1; i<=amount; i++)
        {
            dp[i]=amount+1;
        }
        dp[0]=0;
        for (int j=0; j<=amount; j++)
        {

             for(int k=0; k<coins.length; k++)
             {
                if (coins[k]<=j)
                {
                    dp[j] = Math.min(1+dp[j-coins[k]],dp[j]);
                }
                
             }
        }
        if (dp[amount]<=amount)
        {
            return dp[amount];
        }
        else
        {
            return -1;
        }
    }
}