// Time Complexity : O(mn), m is length of coins array, n is the amount range
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* The exhaustive recursive solution gave a time limit excess -> reduced the extra calculations by using DP */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        // declare 2D matrix, we have 2 variables -> coins array and amount.
        // the matrix size is + 1 because we have to consider the 0 case also.@interface
        int[][] dp = new int[m + 1][n + 1];

        // row 0 and col 0 is 0
        dp[0][0] = 0;

        // assign the value to row 0
        // we can assign the value equivalent to infinity or adding 1 to amount, since
        // we won't pass the amount
        for (int j = 1; j <= n; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // denominaion of coin less than amount, we assign it to the value from previous
                // row
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // else, check minimum between previous row and new sum after choosing the coin
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        // if out of bound or infinity, return -1
        if (dp[m][n] >= amount + 1) {
            return -1;
        }

        return dp[m][n];

    }
}