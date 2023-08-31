import java.util.Scanner;

// Time Complexity : O(m*n), m-> coins length , n-> amount
// Space Complexity : O(m*n)
public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);
        sc.close();
    }

    /**
     * @param coins
     * @param amount
     * @return the fewest number of coins that you need to make up that amount
     */
    private static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 99999;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // first case - if the denomination is greater than amount
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // second case - if the denomination is not greater than the amount
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[coins.length][amount] == 99999)
            return -1;

        return dp[coins.length][amount];
    }
}