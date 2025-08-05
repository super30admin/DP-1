// THis solution uses DP and divides the whole solutions into sub problems where each sub problem calculates fewest number of coins required to calculate the amount - 1,2,3,  etc until the amount given is reached
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        // Define a new dp array which shows - m as the number of coints from 0 to coins.length and n represents the amount from 0 to amount given
        int[][] dp = new int[m+1][n+1];
        int[][] dp = new int[m+1][n+1];give
        // Fill in the first row with max number because with 0 as the given coin count we cannot make any amount.
        for(int i=1;i<n+1;i++) {
            dp[0][i] = 99999;
        }
        
        for(int i = 1;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                // If at all the amount cannot be reached we consider the previous coin range as the output
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else
                    // Otherwise we take the max of previous one or the 1 plus of the choosing the existing coin
                dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
            }
        }
        if(dp[m][n]==99999) return -1;
        return dp[m][n];
    }
}

