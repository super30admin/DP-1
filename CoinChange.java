// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/coin-change/)
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.
// Example:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Constraints:
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Base case : coins array is null or empty
        if (coins == null || coins.length == 0){
            return -1;
        }
        
        // Creating a 2D DP table with dimensions : (number of coins + 1) * (amount + 1)
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int j = 1; j < amount + 1; j++){
            dp[0][j] = amount + 1; // Using amount + 1 as infinity
        }
        
        // Filling the 2D table
        for (int i = 1; i < coins.length + 1; i++){
            for (int j = 1; j < amount + 1; j++){
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1){
            return -1;
        }
        return dp[coins.length][amount];
    }
}