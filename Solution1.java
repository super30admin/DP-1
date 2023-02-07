// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/*
 * I create a dp[][] array of dimensions (coins.length + 1) * (amount + 1). I initially set dp[0][0] as 0 and set all other values of the first row to amount+1 (this helps when the coins aren't in 
 * sorted order). Now I iterate through each element from the second row and set the value of dp[i][j] as that of the value just above it for all j<coins[i-1]. For other instances, 
 * dp[i][j] = minimum of the value just above and 1+value present coins[i-1] places behind in the same row.
 */

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int[coins.length+1][amount+1];
        dp[0][0]=0;
        for(int i=1;i<dp[0].length;i++)
        {
            dp[0][i]=amount+1;
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }

        return dp[coins.length][amount]>amount ? -1 : dp[coins.length][amount];
    }
}