// Time Complexity : O(m^n) where m is the length of the coins array and n is the amount
// Space Complexity : O(m^n) where m is the length of the coins array and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 9999;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i-1][j];
                } 
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        if (dp[coins.length][amount] == 9999) return -1;
        return dp[coins.length][amount];
    }
}