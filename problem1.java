// Time Complexity :O(n*m)
// Space Complexity :nm
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no

/*
 * Approach
 * 
 * here we are building a 2d matrix we are a keeping track of the amount and coins used
 * we comapre the amount from the above col with amount at curr + amount at cur- value of the coin 
 * by this process we buid out the matrix and finally we return the max number and the end of the matrix
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 10;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // till amount is lesser than the demonination of the coin
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // j - coin[i - 1]
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        int re = dp[coins.length][amount];
        if (re >= Integer.MAX_VALUE - 10)
            return -1;
        return re;

    }
}