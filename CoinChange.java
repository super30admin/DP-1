//time complexity - (m*n), space complexity - (m*n) since its using matrix
//Initialize a 2D array dp with dimensions (n+1) x (m+1) to represent the minimum number of coins needed for each amount using the first i coin denominations.
//Populate the array using dynamic programming, where dp[i][j] is the minimum of not using the current coin (dp[i-1][j]) and using the current coin (1 + dp[i][j-coins[i-1]]).
//Return dp[n][m] as the result, or -1 if it's greater than or equal to 99999 (indicating no valid combination was found).
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount;
        int n = coins.length;
        int [][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int j=1;j<=m;j++){
            dp[0][j] = 99999;
        }
        for(int i =1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j<coins[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);

            }
        }
        int res = dp[n][m];
        if(res >= 99999) return -1;
        return res;
    }
}