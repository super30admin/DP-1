/*
 * Coin Change Problem
 * Given an array of coin denominations and a total amount, find the minimum number of coins needed to make that amount.
 * If it is not possible to make that amount, return -1.
 * * Approach:
 * * 1. Use a recursive helper function to explore all combinations of coins.
 * * 2. At each step, either choose the current coin or skip it.
 * * 3. If the amount becomes zero, return the number of coins used.
 * * 4. If the amount becomes negative or all coins are used, return -1.
 * 
 * * Time Complexity: O(2^n) where n is the number of coins, as we explore all combinations.
 * * Space Complexity: O(n) for the recursion stack.
 * 
 * 
 * Optimized Approach:
 * 1. Use dynamic programming to build a table where dp[i] represents the minimum number of coins needed to make amount i.
 * 2. Initialize dp[0] = 0 (0 coins needed to make amount 0) and all other dp[i] to a large value (e.g., Integer.MAX_VALUE).
 * 3. For each coin, iterate through the dp array and update the minimum coins needed for each amount that can be formed with that coin.        
 * 4. Return dp[amount] if it is not equal to Integer.MAX_VALUE, otherwise return -1.
 * 
 * * Time Complexity: O(n * amount) where n is the number of coins and amount is the target amount.
 * * * Space Complexity: O(amount) for the dp array.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        return helper(coins, amount, 0, 0);
    }

    private int helper(int[] coins, int amount, int index, int coinsUsed) {

        if (index == coins.length || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return coinsUsed;
        }

        int notChoose = helper(coins, amount, index + 1, coinsUsed); // Skip the current coin
        int choose = helper(coins, amount - coins[index], index, coinsUsed + 1); // Choose the current coin

        if (notChoose == -1) {
            return choose;
        }
        if (choose == -1) {
            return notChoose;
        }

        return Math.min(choose, notChoose);
    }

    public int coinChangewithDP(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int m = coins.length;
        int n = amount;

        // DP table: dp[i][j] = minimum coins needed to make amount j using first i coins
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row (0 coins), all amounts > 0 are unreachable, set to max value (amount + 1)
        for (int i = 1; i <= n; i++) {
            dp[0][i] = amount + 1; 
        }
        // Build the DP table row-by-row
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If coin is larger than current amount, can't include it
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Choose min between: 
                    // 1. Exclude current coin (dp[i-1][j])
                    // 2. Include current coin (1 + dp[i][j - coin])
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        return dp[m][n] == amount + 1 ? -1 : dp[m][n]; // If we can't make the amount, return -1 else return the value
    }
}
