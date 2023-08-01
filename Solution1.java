// Time Complexity: O(mn) where m is number of coins and n is the amount
// Space Complexity: O(mn)

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= n; i++) {
            dp[0][i] = amount+10;
        }
        for(int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <=n; j++) {
                if( coins[i-1] > j ) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min( dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if( dp[m][n] >= amount+10) {
            return -1;
        }
        return dp[m][n];
    }
}