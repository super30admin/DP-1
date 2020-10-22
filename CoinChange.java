/**
 * TC : O(mn) m = amount, n = length of coins array
 * SC : O(mn)
 * Approach : Exploring minimum change for every value till the given amount.
 *            Storing the minimum for each value, by checking it with it's value at previous denominations with the current denomination
 *            result willl always be at the end of the 2d matrix 
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        int rows = coins.length+1, cols = amount+1;
        int[][] dp = new int[rows][cols];
        for(int i = 1; i < cols; i++){
            dp[0][i] = amount+1;
        }
        
        for(int row = 1; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(col < coins[row-1] ){
                    dp[row][col] = dp[row-1][col];
                }else {
                    dp[row][col] = Math.min(dp[row-1][col],1+dp[row][col - coins[row-1]]);
                }
            }
        }
        if(dp[rows-1][cols-1] > amount) return -1;
        return dp[rows-1][cols-1];
    }
}