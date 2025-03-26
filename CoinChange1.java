// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

This approach uses dynamic programming with a 2D table to determine the minimum number of coins
needed to make up a given amount. We initialize the first row (except dp[0][0]) with a large value
since no amount can be formed without coins. Then, we iterate through the coins and update the table
based on whether we include or exclude each coin. If a coin's value is greater than the current amount,
 we carry forward the previous value; otherwise, we take the minimum of excluding the coin or including
 it (adding one to the result of the remaining amount). The final answer is stored in dp[m][n],
  returning -1 if no valid combination exists.
* */
class CoinChange1 {
    public int coinChange(int[] coins, int amount) {

        //2D ARRAY solution

        int m=coins.length;
        int n = amount;

        int[][] dp=new int[m+1][n+1];
        for(int j=1;j<=n;j++)
        {
            //why this value
            dp[0][j]=99999;
        }

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[m][n]==99999)
        return -1;
        return dp[m][n];

    }
}