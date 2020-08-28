//Top down

//Time Complexity= O(N^2)
//Space Complexity =O(N^2)
class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 99999;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    // Copy value from top
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // go coins steps back plus 1 OR TOP
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);

                }

            }
        }

        return dp[coins.length][amount] >= 99999 ? -1 : dp[coins.length][amount];

    }
}