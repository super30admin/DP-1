// dp solution where we store the elements in m * n matrix  build on prev soln and return the final index 
// as solution
// Time Complexity : o(m*n)
// Space Complexity :o(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return 0;
        }
        int[][] dp = new int [coins.length + 1][amount + 1];
        for(int j = 1; j < amount + 1; j++) {
            dp[0][j] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) { 
                    // this case where the coin value is too large to contribute to sum so we use prev sum
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    // this case we take min of one right above this cell the one without the coin and 
                    // j - coins[i - 1] cells back + 1 a pattern we observed throughout
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}