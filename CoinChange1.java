import java.util.Arrays;

class Solution {

    // time - O(m*n)
    // space- O(m*n)

    public int coinChange(int[] coins, int amount) {
        int maxCoins = amount + 1; // we cantake 99999 also
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 0;
        Arrays.fill(dp[0], maxCoins);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];

        return result >= maxCoins ? -1 : result;
    }
}
