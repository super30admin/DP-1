//https://leetcode.com/problems/coin-change/
/*
Time: O(coins*total)
Space: O(coins*total)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

*/
public class CoinChange {

    public int coinChange(int[] coins, int total) {
        int m = coins.length;
        int V = total;
        int[][] dp = new int[m + 1][V + 1];

        for (int j = 0; j < V + 1; j++)
            dp[0][j] = Integer.MAX_VALUE;

        for (int i = 0; i < m + 1; i++)
            dp[i][0] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);

                else
                    dp[i][j] = dp[i - 1][j];

            }
        }

        return dp[m][V] == Integer.MAX_VALUE ? -1 : dp[m][V];

    }
}
