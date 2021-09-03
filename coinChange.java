// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : None.


class coinChange{
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];
        for (int i=1; i < dp.length; i++) {
            dp[i] = dp.length;
            for(int c: coins) {
                if(i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1); 
                }
            }
        }
        if(dp[amount] == dp.length) return -1;

        return dp[amount];
    }
}