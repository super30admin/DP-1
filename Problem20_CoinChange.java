// Time Complexity : O(nd), n -> target amount, d -> number of coin denominations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    min = Math.min(min, dp[i - coins[j]] + 1);
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}