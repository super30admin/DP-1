/**
 * Leet Code : https://leetcode.com/problems/coin-change/description/
 *
 * Approach:
 * This is a bottom-up dynamic programming solution using a 2D dp table.
 * dp[i][j] represents the minimum number of coins needed to make amount j using the first i coins.
 * For each coin, you can either not pick it (dp[i-1][j]) or pick it (1 + dp[i][j - coin]).
 *
 * Time Complexity: O(N * A), where N = number of coins, A = amount.
 * Space Complexity: O(N * A) for the dp table.
 */
public class CoinChangeDp {

    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length + 1][amount + 1];
        // Initialize base cases: 0 coins can't make positive amounts
        for (int i = 1; i <dp[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE - 100;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < coins[i -1]) dp[i][j] = dp[i - 1][j]; // Can't pick coin
                else {
                    // Pick or not pick the coin
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - (coins[i -1])] + 1);
                }
            }
        }
        int count = dp[coins.length][amount];
        return count >= Integer.MAX_VALUE - 100 ? -1 : count;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeDp().coinChange(new int[]{1, 2, 5}, 11));
    }
}
