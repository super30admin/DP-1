// Time Complexity : O(n * m), where n is number of coins, m is the amount
// Space Complexity : O(n * m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use dp here. In the 2d dp array rows indicate the coins and columns indicate the 0....amount. On each cell we take
   minimum of when we dont choose the current coin dp[i-1][j] and when we choose the coin dp[i][j - coins[i - 1]] + 1. 
   At the end the value stored in dp[n][m] gives us the no of coins. If its greater than amount that means there's no way and 
   we return -1.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;
        
        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 0;
        for(int j = 1; j <= amount; ++j)
            dp[0][j] = amount + 1;

        for(int i = 1; i < dp.length; ++i) {
            for(int j = 0; j < dp[0].length; ++j) {
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        if(dp[n][m] > amount)
            return -1;
            
        return dp[n][m];
    }
}