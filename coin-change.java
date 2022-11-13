//time and space complexity is O(n*m) where n is length of coins array and m is the amount
class Solution {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // setting first row to infinity (max)
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                // j is the amount and i-1 gives the coin denomination. we do -1 because we
                // added an extra row
                if (j < coins[i - 1]) {
                    // do not choose case
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        if (dp[n][amount] == amount + 1) {
            return -1;
        }

        return dp[n][amount];

    }
}