import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * The brute force with exponential runtime is to generate all possible
 * solutions possible and then find the one with minimum number of coins. 
 * 
 * In the dynamic programming approach, we solve problem bottom up, and store the
 * optimal solution to subproblems to be reused later on.
 * 
 * Time Complexity: O(nm) n is the amount and m is the number of coins Space
 * Complexity: O(n)
 * 
 * Leetcode Result:
 * 
 * Runtime: 8 ms, faster than 92.49% of Java online submissions for Coin Change.
 * Memory Usage: 35.9 MB, less than 95.27% of Java online submissions for Coin
 * Change.
 */

public class CoinChange {

    /**
     * Find fewest number of coins to make the amount.
     * 
     * @param coins  available denomination
     * @param amount target
     * @return fewest number of coins that constitute the amount.
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }
}