// Time Complexity : O(n * amount) (n is coins.length)
// Space Complexity : O(n*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Coin Change
// Your code here along with comments explaining your approach
class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length + 1][amount + 1];
        int ans =  coinChange(coins, amount, coins.length);
        return ans>= Integer.MAX_VALUE/2 ? -1: ans;
    }
    public int coinChange(int [] coins, int amount, int n) {
        if(amount == 0) {
            return 0;
        }
        else if(n <= 0) {
            return Integer.MAX_VALUE/2;
        }
        else if(dp[n][amount] != null) {
            return dp[n][amount];
        }
        if(amount >= coins[n-1]) {
            return dp[n][amount] = Math.min(1 + coinChange(coins, amount-coins[n-1], n), coinChange(coins, amount,n-1));
        }
        else {
            return dp[n][amount] = coinChange(coins, amount, n-1);
        }
    }
}
