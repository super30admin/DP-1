//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length + 1;
        int m = amount + 1;

        int[][] dp = new int[n][m];

        for(int j = 1; j < m; j++) dp[0][j] = 99999;

        for(int i = 0; i < n; i++) dp[i][0] = 0;

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j < m; j++)
            {
                if(j < coins[i - 1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
            }
        }
        return dp[n - 1][m - 1] == 99999 ? -1 : dp[n - 1][m - 1];
    }
}