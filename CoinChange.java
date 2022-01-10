// Time Complexity : O(m*n)
// Space Complexity : O(m*n) where m = coins.length and n = amount
// Did this code successfully run on Leetcode : Yes

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        //  base case
        dp[0][0] = 0;

        //  top row
        for (int j = 1; j < dp[0].length; ++j) {
            dp[0][j] = amount + 1;
        }

        //  calculating result
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                //  if current denomination > amount, copy from row above
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                //  calculate min value between row above and denomination columns before + 1
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        return result > amount ? -1 : result;
    }
}
