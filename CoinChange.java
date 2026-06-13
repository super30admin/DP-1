class Solution {
    // TC - O(n * m)
    // SC - O(n * m)
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;

        //initialize dp array to store the min required coins, the first row is initialized to maximum value for comparison purposes
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= m; j++) {
                // if the amount at current index is less than the coins[i - 1] value (if amount is 2 and coind value is 5) then we just take value from the row
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // else we calculate minimum of the value row above has and the total of value at index position
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
                }
            } 
        }

        if (dp[n][m] > amount) {
            return -1;
        }

        return dp[n][m];
    }
}
