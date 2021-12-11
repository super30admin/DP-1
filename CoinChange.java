// Time Complexity : O((amount*n)
// Space Complexity : O((amount*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        // When no coins are there, we can't make up the amount
        if(coins.length ==0) {
            return -1;
        }

        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];

        // Setting up the 0th row as infinity or the amount+1 here
        // because we number of coins to make the jth column amount using 0 coins are infinity in theory and amount+1 in code
        for (int j =1; j<=amount;j++) {
            dp[0][j] = amount+1;
        }

        for(int i = 1; i<=n;i++) {
            for(int j =1; j<=amount; j++) {

                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                // There can be two scenarios
                // Don't take the current coin - we will fetch the precomputed ans from one row above
                // Take the current coin - we will add 1 to the ans(as we are taing the current coin at ith row) and find the min coins required for amount- coins(i-1)th
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }

        // Check if the ans is amount+1(infinity), then we have not found an ans, return -1
        if(dp[n][amount] > amount) {
            return -1;
        }
        // Else, Our ans will be in the last row and last col
        return dp[n][amount];
    }
}
