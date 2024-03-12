// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }

            }
        }
        if (dp[n][m] > amount)
            return -1;
        return dp[n][m];
    }
}
// Exhaustive approach - Time Limit Exceeded
// class Solution {
// public int coinChange(int[] coins, int amount) {
// if (coins == null || coins.length == 0)
// return -1;
// int index = 0;
// int count = 0;
// return (helper(coins, amount, index, count));
// }

// public int helper(int[] coins, int amount, int index, int count) {
// // base
// if (amount == 0) {
// return count;
// } else if (index == coins.length || amount < 0) {
// return -1;
// }

// // logic
// int dontChoose = helper(coins, amount, index + 1, count);
// int choose = helper(coins, amount - coins[index], index, count + 1);
// if (dontChoose == -1)
// return choose;
// else if (choose == -1)
// return dontChoose;

// return Math.min(dontChoose, choose);
// }
// }