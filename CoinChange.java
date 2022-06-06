// recursive approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        // null
        return helper(coins, 0, amount, 0);
    }

    private int helper(int[] coins, int i, int amount, int mincoins) {
        // base
        if (amount == 0)
            return mincoins;
        if (amount < 0 || i == coins.length)
            return -1;

        // logic
        // choose
        int case1 = helper(coins, i + 1, amount, mincoins);
        int case2 = helper(coins, i, amount - coins[i], mincoins + 1);
        if (case1 == -1)
            return case2;
        if (case2 == -1)
            return case1;
        return Math.min(case1, case2);
    }
}

// DP bottom up approach
// Time Complexity : O(n^2)
// Space Complexity : O(no of coins x amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        for (int z = 1; z < dp[0].length; z++) {
            dp[0][z] = 99999;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }
        if (dp[m][n] >= 99999)
            return -1;
        else
            return dp[m][n];
    }
}