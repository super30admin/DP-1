// Time Complexity :O(m*n) where m is the number of coins and n is the amount
// Space Complexity :O(n) where n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        // null
        if (coins.length == 0 || coins == null)
            return 0;
        // construct dp table
        int[] dp = new int[amount + 1];
        for (int j = 1; j < dp.length; j++) {
            dp[j] = amount + 1;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}