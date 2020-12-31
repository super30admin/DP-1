//https://leetcode.com/problems/coin-change/
//Time Complexity : O(coins*amount)
//Space Complexity : O(coins*amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int j = 1; j < amount + 1; j++)
            dp[0][j] = amount + 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin_value = coins[i - 1];
                if (coin_value > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin_value] + 1);
                }
            }
        }
        int result = dp[coins.length][amount];
        return result == amount + 1 ? -1 : result;
    }
}