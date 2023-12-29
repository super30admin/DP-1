import java.util.*;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // return coinChangeExhaustiveSearch(coins, amount);
        // return coinChangeTwoDimensionalDP(coins, amount);
        return coinChangeOneDimensionalDP(coins, amount);
    }

    // TC: O(M * amount) where M is the length of coins
    // SC: O(amount)
    private int coinChangeOneDimensionalDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // TC: O(M * amount) where M is the length of coins
    // SC: O(M * amount) where M is the length of coins
    private int coinChangeTwoDimensionalDP(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else if (dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][amount] == Integer.MAX_VALUE ? -1 : dp[m][amount];
    }

    // TC: O(2 ^ (M + amount)) where M is the number of coins
    private int coinChangeExhaustiveSearch(int[] coins, int amount) {
        int res = helper(coins, amount, 0, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(int[] coins, int amount, int start, int coinsUsed) {
        if (amount < 0 || start == coins.length) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return coinsUsed;
        }
        int notChoose = helper(coins, amount, start + 1, coinsUsed);
        int choose = helper(coins, amount - coins[start], start, coinsUsed + 1);
        return Math.min(notChoose, choose);
    }
}
