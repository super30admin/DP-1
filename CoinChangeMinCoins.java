// Time Complexity : O(nm) //iterating over entire nums array : Optionation for previous exponential solutions
// Space Complexity : O(mxn) // m = amount, n = total different denomination coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Learning DP. Able to code post watching videos. Please validate time complexity.

/*
Built two dimension array for Repeated sub problem. Based on that computation came up with this solution.
We have 2 route choose coin or not. Calculate minimum at every step.
*/

public class CoinChangeMinCoins {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;

        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int j=1; j<=m; j++){
//          dp[1][j] = Integer.MAX_VALUE;
            dp[0][j] = 99999;
        }

        for(int i=1; i<=n ; i++) {
            for(int j=1; j<=m; j++){
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] , 1+ dp[i][j-coins[i-1]]);
                }

            }
        }
        int result = dp[n][m];
        if(result>= 99999) return -1;

        return result;
    }
}