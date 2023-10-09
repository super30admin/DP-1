// Time Complexity : O(M*N) where M is number of coins and N is target amount
// Space Complexity : O(M*N) where M is number of coins and N is target amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange1
{
    class Solution
    {
        public int coinChange(int[] coins, int amount)
        {
            int r = coins.length+1;
            int c = amount+1;
            int[][] dp = new int[r][c];

            for(int i = 1; i< c; i++)
                dp[0][i] = Integer.MAX_VALUE-20;

            for(int i = 1; i< r; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    if(j < coins[i-1])
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.min(dp[i-1][j], 1+(dp[i][j-coins[i-1]]));
                }
            }
            return dp[r-1][c-1] >= Integer.MAX_VALUE-20 ? -1 : dp[r-1][c-1] ;
        }

        public int coinChangeRecursive(int[] coins, int amount)
        {
            return helper(coins, amount, 0, 0);
        }

        public int helper(int[] coins, int remainingAmount, int idx, int coinsUsed)
        {
            // base case
            if(remainingAmount == 0)
                return coinsUsed;
            else if(remainingAmount < 0 || idx >= coins.length)
                return -1;

            int choosenPath =  helper(coins, remainingAmount- coins[idx], idx, coinsUsed+1);
            int nonChoosenPath = helper(coins, remainingAmount, idx+1, coinsUsed);

            if(choosenPath == -1)
                return nonChoosenPath;
            if(nonChoosenPath == -1)
                return choosenPath;
            return Math.min(choosenPath, nonChoosenPath);
        }
    }
}
