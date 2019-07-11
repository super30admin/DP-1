// Time Complexity :O(n*M) where m is no of coins and N is the amount
// Space Complexity :O(S) the space of the memoization table
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Taking into mind to take coins[i-1] in the dp!!



 //Dynamic Programming

 class Solution {
    public int coinChange(int[] coins, int amount) {

         int [][] dp = new int[coins.length+1][amount+1];

         for(int i =0 ; i<=coins.length ;i++)
        {
            dp[i][0] = 0;
        }

          for(int j =1 ; j<=amount ;j++)
        {
            dp[0][j] = 9999;
        }

         for(int i = 1 ; i<coins.length+1 ; i++)
            for(int j = 1 ; j<amount+1 ; j++)
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else            
                 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
            }

         int result = dp[coins.length][amount];

         if(result>=9999)
            return -1;
        else 
            return result;



     }
}
