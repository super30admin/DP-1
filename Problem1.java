// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Since we have two variable to consider we are using 2D array for calculating all the possible outcomes using the given coins and then in the last row of the last column we will get the maximum amount that can be formed using all the coins

class Solution {
    public int coinChange(int[] coins, int amount) {
    int m=amount;
    int n=coins.length;

    int[][] dp=new int[n+1][m+1];

    for(int j=1;j<=amount;j++)
    {
        //this will contain infinity or any number greater than amount
        dp[0][j]=amount+1;
    }
    
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            //We need to keep the value in the row until the amount is reached, same as the previous row.

            if(j<coins[i-1])
            {
                dp[i][j]=dp[i-1][j];
            }

            else
            {
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }
    }
    if (dp[n][m]>=amount+1 ) return -1;
    return dp[n][m];
    }
    }