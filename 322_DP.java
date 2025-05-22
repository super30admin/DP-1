// Time Complexity: O(m * n)
// - m is the number of coin denominations
// - n is the target amount
// We iterate over every coin and every amount from 1 to n once.

// Space Complexity: O(m * n)
// - A 2D DP array of size (m+1) x (n+1) is used


class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][]dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<=n;++i)
            dp[0][i] = amount+10;
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[m][n] >= amount +10 ? -1 : dp[m][n];
    }
}
