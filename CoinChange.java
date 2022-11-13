import java.util.Objects;

/**
 * TC - O(m * n) - where m is coins array length and n is an amount
 * SC - O(m * n) - where m is coins array length and n is an amount
 */
public class CoinChange {
        public int coinChange(int[] coins, int amount) {
            if (Objects.isNull(coins) || coins.length == 0) {
                return -1;
            }
            int[][] dp = new int[coins.length + 1][amount + 1];

            for(int i = 1; i < amount + 1; i++) {
                dp[0][i] = amount + 1;
            }

            for (int i = 1; i< coins.length + 1; i++) {
                for(int j = 1; j < amount + 1; j++) {

                    if (j < coins[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                    }
                }
            }

            if (dp[coins.length][amount] == amount + 1) {
                return -1;
            }


            return dp[coins.length][amount];
        }
}
