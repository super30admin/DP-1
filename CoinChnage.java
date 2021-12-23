public class CoinChnage {
    public int coinChange(int[] coins, int amount) {
        // TC: O(N2)
        // SC: O(coins.length * amount)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        if (coins == null || coins.length == 0)
            return 0;

        // instantiated 2D dp array
        // number of rows = coins.length + 1, since we are using 0 coin as well
        // number of cols = amount + 1, since we are cosindering amount 0 as well

        int[][] dp = new int[coins.length + 1][amount + 1];
        // initialise maximum amount (infinite) from 1st col to last col of the zero th
        // row.
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                // if amount is less than denomination
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }

        // last index --> dp[coins.length][amount]
        if (dp[coins.length][amount] > amount)
            return -1;

        return dp[coins.length][amount];

    }

}
