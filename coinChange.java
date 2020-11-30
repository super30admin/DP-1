// Time Complexity :O(MN), where N is number of rows and M is number of columns
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0){
            return 0;   
        }
        int[][]dp = new int[coins.length+1][amount+1];
        int row = dp.length; 
        int column = dp[0].length; 
        for (int i = 1; i<column; i++){
            //Avoid the overflow issue (can take any higher value or amount + 1)
           dp[0][i] = amount + 1;
        }
        for (int i = 1; i <row; i++) {
            for (int j = 1; j < column; j++) {
                //Only if previous coins value is not calculated
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        if (dp[row-1][column-1] == amount+1) {
            return -1;
        }
        return dp[row-1][column-1];
    }
}