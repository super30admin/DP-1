// Time Complexity : O(mxn) where m = amount + 1 and n = coins.length + 1
// Space Complexity : O(mxn) where m = amount + 1 and n = coins.length + 1 since we are using 2-D arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Recusive approach exceeds time limits for large data sets and hence using DP solution

class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0) return -1;

        return helper(coins, amount, 0, 0);

    }

    private int helper(int[] coins, int amount, int index, int coinsUsed) {
        // base case
        if (index == coins.length || amount < 0) {
            return -1;
        }

        int[][] dp = new int[coins.length+1][amount+1];

        // Populating first row with all infinity
        for (int j=1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }

        // populating general cases in the matrix
        for (int i = 1; i < coins.length+1; i++) {
            for (int j=1; j<amount+1; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                }
            }
        }

        if (dp[coins.length][amount] == amount + 1) return -1;

        return dp[coins.length][amount];

    }
}
