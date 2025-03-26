// https://leetcode.com/problems/coin-change/)

//Time Complexity: O(n*m) where n is the number of coins and m is the amount
//Space Complexity: O(n*m) where n is the number of coins and m is the amount

/**
 * Solves the coin change problem using a bottom-up dynamic programming approach.  
 * Builds a DP table where dp[i][j] represents the minimum coins needed for amount `j` using first `i` coins.  
 * Returns the minimum number of coins required or -1 if the amount cannot be formed.
 */

public class CoinChange {
    
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 99999;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) { // If amount is less than the coin value
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        int result = dp[coins.length][amount];
        if (result >= 99999)
            return -1;
        return result;
    }
}
