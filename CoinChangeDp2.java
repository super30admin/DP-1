/**
 * Leet Code : https://leetcode.com/problems/coin-change/description/
 *
 * Approach:
 * This is a bottom-up dynamic programming solution using a 1D dp array.
 * dp[j] represents the minimum number of coins needed to make amount j.
 * For each coin, update the dp array for all amounts >= coin value.
 *
 * Time Complexity: O(N * A), where N = number of coins, A = amount.
 * Space Complexity: O(A) for the dp array.
 */
public class CoinChangeDp2 {

    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        // Initialize base cases: 0 coins needed for amount 0, large value for others
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 100;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) dp[i] = dp[j]; // Can't pick coin
                else {
                    // Pick or not pick the coin
                    dp[j] = Math.min(dp[j], dp[j - (coins[i - 1])] + 1);
                }
            }
        }
        int count = dp[amount];
        return count >= Integer.MAX_VALUE - 100 ? -1 : count;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeDp2().coinChange(new int[]{1, 2, 5}, 11));
    }
}
