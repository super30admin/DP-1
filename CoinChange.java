// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity: O(mxn)
// Space Complexity: O(mxn)
// Idea is to use dynamic programming to solve sub problems.
// Each sub problem has two paramaters. One parameter is subarray of coins and other is the sum of the coins value
// We use bottom-up approach to construct sub problems for subarray of coins and particular sum.
// Use 2d matrix to store these sub problem values and use them for next sub problem.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j=1;j<=n;j++)
        {
            dp[0][j] = 99999;
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(j>=coins[i-1])
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[m][n] == 99999) return -1;
        return dp[m][n];
    }
}