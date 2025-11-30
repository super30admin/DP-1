// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 2D DP
        // // 0 to coins is row
        // // 0 to amount is col
        // int[][] dp = new int[coins.length+1][amount+1];
        // // set first row (coin 0) to max value - coz we are considering min
        // // we can consider amount+1 as max value
        // for(int i = 1; i <= amount; i++)
        // {
        //     dp[0][i] = amount+1;
        // }

        // for(int i = 1; i <= coins.length; i++)
        // {
        //     for(int j = 0; j <= amount; j++)
        //     {
        //         if(coins[i-1] > j)
        //         {
        //             // as value as the grid above
        //             dp[i][j] = dp[i-1][j];
        //         }
        //         else
        //         {
        //             dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j - coins[i-1]]);
        //         }
        //     }
        // }

        // if(dp[coins.length][amount] >= amount + 1)
        // {
        //     return -1;
        // }
        // return dp[coins.length][amount];
        
        // 1D DP
        int dp[] = new int[amount+1];
        for(int i = 1; i <= amount; i++)
        {
            dp[i] = amount+1;
        }
        for(int i = 1; i <= coins.length; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                if(coins[i - 1] > j)
                {
                    dp[j] = dp[j];
                }
                else
                {
                    dp[j] = Math.min(dp[j], dp[j- coins[i-1]] + 1);
                }
            }
        }
        if(dp[amount] >= amount+1) return -1;
        return dp[amount];
    }
}

