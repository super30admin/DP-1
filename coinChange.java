// TC: O(mn)
// SC: O(m + n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null) {
            return -1;
        }
        
        int n = amount;
        int m = coins.length;
        
        int dp[][] = new int[m + 1][n + 1];
        
        for(int j = 0; j < n + 1; j++) {
            dp[0][j] = amount + 1;
        }
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[m][n] == amount + 1) {
            return -1;
        }
        return dp[m][n];
    }
}
