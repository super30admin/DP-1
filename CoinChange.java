// Time Complexity : O(coins.length+1 * amount+1)
// Space Complexity : O(coins.length+1 * amount+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length;
        
        int[][] dp = new int[rows+1][amount+1];
        
        for(int i=1;i<dp[0].length;i++)
            dp[0][i] = 99999;
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(j<coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        if(dp[rows][amount]>=99999)
            return -1;
        
        return dp[rows][amount];
    }
}
