// Problem: Coin Change
// for repeated subproblems we use dynamic programming
// we have two decision making params : one - coins, other - amount
// so we use dp matrix
// if amount is smaller than denomination, there is not availability of choose case
// choose case comes from straight above in tabulation

// Time : O(m x n)  m = coins, n = amount
// Space : O(m x n)  m = coins, n = amount

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1]; // decision matrix for 2 decision params
        // dp[0][0] = 0;
        for(int j=1; j<=n; j++) {
            dp[0][j] = 99999; // to choose min choose larger num
        }

        // filling dp matrix
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]) { // amount < denomination of the coin
                    // no choose case
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]); // number of steps going back
                }
            }
        }
        if(dp[m][n] == 99999) return -1;
        return dp[m][n];
    }
}