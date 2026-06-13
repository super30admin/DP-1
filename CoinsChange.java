// Time Complexity:O(n*m)
// Space complexity: O(n*m)
//We build a 2D DP table where dp[i][j] is the min coins to make amount j using first i coins.
// If we can't pick the current coin, we just use the value from the row above.
// Otherwise, we take the min between skipping it and picking it (which adds 1 coin)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length;
        int columns = amount;
        // declare a 2-D Array to capture the values of no of coins for a given amount
        int[][] dp = new int [rows+1][columns+1];
        // fill first row with value > total amount
        for (int col = 0; col<= columns; col++) {
            dp[0][col] = amount+1;
        }
        // fill the remaining rows and clolumns of the table
        for(int i = 1; i <= rows; i++){

            for(int j= 1; j<= columns; j++) {
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        if(dp[rows][columns] > amount) return -1;
        return dp[rows][columns];
    }
}