/*
  Time complexity: O(m*n)
  Space complexity: O(m*n)

  Code ran successfully on Leetcode: Yes

  Approach: We build a tree where at each node we make a decision as to whether we choose or not choose a coin of a particular denomination.
*/

public class Solution {
    public int CoinChange(int[] coins, int amount) {
        int m = amount;
        int n = coins.Length;

        int[][] dp = new int[n+1][];

        for(int i=0;i<dp.Length;i++)
        {
            dp[i] = new int[m+1];
        }
        dp[0][0]=0;
        for(int i=1;i<=m;i++)
        {
            dp[0][i] = m+1;
        }

        for(int i=1;i<=n;i++)
        {
            dp[i][0] = 0;
        }

        for(int i = 1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.Min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
            }
        }

        if(dp[n][m]>m) return -1;
        else return dp[n][m];
    }
}
