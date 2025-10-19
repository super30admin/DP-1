/**
 * Memoization
 * Time Complexity: o(coinsLength * amount)
 * Space Complexity: o (coinsLength * amount)
 */
public class CoinChange2 {

    private int[][] memo;


    public int coinChange(int[] coins, int amount) {
        int coinLength = coins.length;
        int[][] dp = new int[coinLength + 1][amount + 1];

        dp[0][0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 100;
        }
        for (int i = 1; i < coinLength; i++) { // for every coin
            for (int j = 1; j <= amount; j++) { // fill the possibilities
                if (j < coins[i - 1]) { // if amount is less then the coin denomination, copy from top (previous computation)
                    dp[i][j] = dp[i - 1][j];
                } else
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
            }

        }
        return dp[coinLength][amount];
    }


    public static void main(String[] args) {
        int i = new CoinChange2().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}
