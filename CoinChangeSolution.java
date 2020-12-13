// Time Complexity : O(N*A) , where A is amount
// Space Complexity : O(A), DP array is of size amount+1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return -1;
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1; i<=amount; i++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return dp[amount];
        
    }
}