/**
*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. 
* If that amount of money cannot be made up by any combination of the coins, return -1. 
* 
* Fill up first row with 0 coins with amount + 1 to indicate the amount cannot be formed. 
* If the amount you want to generate is less than the coin value, use previous row values.
* Else take a minimum of previous row value (Didnt select the current row value) or (1 + current row, column - coin[i-1]) value
* Time and space complexity O(MN)
*
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return 0;
        int[][]dp = new int[coins.length+1][amount+1];
        int n = dp.length; //row
        int m = dp[0].length; //colums
        for (int i = 1; i<m; i++){
           dp[0][i] = amount + 1;
        }
        for (int i = 1; i <n; i++) {
            for (int j = 1; j < m; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if (dp[n-1][m-1] == amount+1) {
            return -1;
        }
        return dp[n-1][m-1];
    }
}
