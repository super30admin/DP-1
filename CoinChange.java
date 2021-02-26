// Time Complexity : O(n * amount), where n is the length of the coins array
// Space Complexity : O(n * amount)

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length + 1;
        int m = amount + 1;
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], amount + 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        return dp[n - 1][m - 1] == amount + 1 ? -1 : dp[n - 1][m - 1];
    }
}
