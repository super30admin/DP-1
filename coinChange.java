// Time Complexity: O(mn), where n=coins.length and m= amount
// Space Complexity: O(mn)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int n=coins.length;
        
        // base case : if we have only one denomination
        if(n==1)
        {
            return amount%coins[0]==0? amount/coins[0]: -1;
        }
        
        
        int[][] dp=new int[n][amount+1];
        
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
              if(i==0)
                {
                     // if the current value j can not be formed with the denomination(coins[i]), assign infinity (in this case as we know the max no. of coins can not be greater than the actual amount)
                       dp[i][j]=j%coins[i]==0? j/coins[i]:amount+1 ;
                }
               else
               {
                   // if j is smaller than the current denomination then, we do not pick that denomination. Hence, get the value from the above row
                  if(coins[i]> j)
                    {
                         dp[i][j]=dp[i-1][j];
                    }
                    else
                    {
                        // if j is greater than or equalto the current denomination then, we should pick the min value that we get when we pick that denomination and when we donot pick that denomination.
                        dp[i][j]=Math.min(dp[i-1][j], 1 + dp[i][j-coins[i]]);
                    }
               }
                
                
            }
        }
        
    
       return  (dp[n-1][amount]==0 || dp[n-1][amount]> amount)?-1:dp[n-1][amount];
    }
}