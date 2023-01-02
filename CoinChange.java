// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {

    //Results in TLE
    public int coinChangeRec(int[] coins, int amount) {
        return helper(coins, amount, 0, 0);
    }

    private int helper(int[] coins, int amount, int index, int coinsUsedCount) {
        if (amount == 0) {
            return coinsUsedCount;
        }

        if (amount < 0 || index == coins.length) {
            return -1;
        }

        //choose
        int case1 = helper(coins, amount - coins[index], index, coinsUsedCount + 1);
        //not choose
        int case2 = helper(coins, amount, index + 1, coinsUsedCount);
        if (case1 == -1) {
            return case2;
        }
        if (case2 == -1) {
            return case1;
        }
        return Math.min(case1, case2);
    }

    public int coinChangeDP(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        if (dp[m][n] >= amount + 1) {
            return -1;
        }
        return dp[m][n];
    }
}