/**
 * TC: O(amount * number of coins)
 * SC: O(amount * number of coins)
 * LeetCode: Y(https://leetcode.com/problems/coin-change/)
 * Approach: 
    Use dp instead of recursion to prevent redundant function calls
    Populate dp matrix by making the best decision whether selecting the current coin or not
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // check edge case
        if(coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }
        
        // initialize dp matrix
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // Fill the first row with an invalid maximum value
        Arrays.fill(dp[0], amount + 1);
            
        // Fill the dp matrix values one-by-one
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                
                // copy values from the top row until the current coin value reaches the current amount
                if(j < coins[i -1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // check for best decision whether or not to select current coin
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        // check if given amount is possible in the given coin denominations if not return -1
        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        
        // return a valid result if it exists
        return dp[coins.length][amount];
    }
}
