/*
 * Time Complexity - Recursive: O(2^n), where n = amount
 * Time Complexity - DP: O(n * m), where n = number of coins, m = amount
 * 
 * Space Complexity - Recursive: O(n) due to recursion stack
 * Space Complexity - DP: O(n * m) for the 2D dp array
 * 
 * Approach - 
 * Recursive:
 * - For each coin, I try two choices: skip the coin or take the coin and reduce the amount.
 * - If the amount becomes 0, return 0 (base case).
 * - If the amount becomes negative or coins are exhausted, return MAX (invalid).
 * - Final result is the minimum coins needed among all paths.
 * 
 * DP:
 * - I use a 2D array dp[i][j], where i = number of coins considered, j = target amount.
 * - dp[0][j] is initialized to max since no amount can be formed without any coins.
 * - For each coin and amount, I choose the minimum between:
 *     - Not taking the current coin (dp[i-1][j])
 *     - Taking the current coin once and solving for the remaining amount (1 + dp[i][j - coins[i-1]])
 * - Final result is found at dp[n][amount]. If it remains MAX, return -1 as no combination was found.
 */

public class Problem_1 {
    static int coinChange_recursive(int[] coins, int amount) {
        int result = helper(coins, 0, amount);
        if (result >= Integer.MAX_VALUE - 10) {
            return -1;
        } else {
            return result;
        }
    }

    static int coinChange_dp(int[] coins, int amount) {
        int m = amount;
        int n = coins.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = Integer.MAX_VALUE - 10;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[n][m] >= Integer.MAX_VALUE - 10) {
            return -1;
        }
        return dp[n][m];
    }

    static int helper(int[] coins, int idx, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || idx == coins.length) {
            return Integer.MAX_VALUE - 10;
        }

        int a = helper(coins, idx + 1, amount);
        int b = 1 + helper(coins, idx, amount - coins[idx]);
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange_recursive(coins, amount));
        System.out.println(coinChange_dp(coins, amount));

    }
}
