// Time Complexity: O(m * amount), where m is the number of coin denominations.
// Space Complexity: O(m * amount), for the 2D DP table.
// Approach: Unbounded Knapsack (Bottom-Up Dynamic Programming).
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        for(int j=1; j<=n; j++) {
            dp[0][j] = Integer.MAX_VALUE-10;
        }

        for(int i=1; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        return dp[m][n] >= Integer.MAX_VALUE-10 ? -1 : dp[m][n];
    }
}