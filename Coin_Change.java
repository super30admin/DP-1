class Solution {
    //Time O(m*n)
    //Space O(m*n)
/*
Intution : Given infinite number of coins we can choose or not chose , when go with greedy there might a case we miss the target amount by choosing larger coin amounts. So we can try for DP solution and here there are repeated subproblems
*/
    public int coinChange(int[] coins, int amount) 
    {
       if(coins == null || coins.length == 0)
       {
           return -1;
       }
       int dp[][] = new int[coins.length+1][amount+1];
       for(int i=0 ; i<dp.length ; i++)
       {
           dp[i][0] = 0;
       }
       for(int j=1 ; j<dp[0].length ; j++)
       {
           dp[0][j] = amount+1; // because we cannot use make mor than amount+1 coins
       }
       for(int i=1 ; i<dp.length ; i++)
       {
           for(int j=1 ; j<dp[0].length ; j++)
           {
               if(coins[i-1] > j)
               {
                   dp[i][j] = dp[i-1][j];
               }
               else 
               {
                   dp[i][j] = Math.min(dp[i-1][j] , 1+dp[i][j-coins[i-1]]);
               }
           }
       }
       if(dp[dp.length-1][dp[0].length-1] >= amount + 1)
       {
           return -1;
       }
       return dp[dp.length-1][dp[0].length-1];
    }

}