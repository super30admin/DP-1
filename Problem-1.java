// Time Complexity : O(m x n) [m: number of coins; n: amount]
// Space Complexity : O(m x n) [m: number of coins; n: amount]
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;

        // 1. construct dp table
        int[][] dp = new int[coins.length + 1][amount + 1];

        // 2. fill the first column
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // 3. fill the first row with infinity
        for (int j = 1; j < dp[0].length; j++) {
            // (instead of infinity we can use highest possible number, which can be greater
            // than amount)
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    // denomination is less than amount, so this is Zero case, get the value from
                    // immediate above row
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // we store minimum of Zero case Or One case
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        // result will be always in the last position of dp table
        int result = dp[dp.length - 1][dp[0].length - 1];

        if (result > amount) // invalid case
            return -1;

        return result;

    }

}
