//COIN CHANGE

// Time Complexity : O(mn), where m is the number of rows and n is the number of columns in the dp matrix
// Space Complexity : O(mn), where m is the number of rows and n is the number of columns in the dp matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) // Cannot proceed if the array itself is not initialized or if the there are no elements in the coins array
            return -1;
        int rows = coins.length; // Each of the rows will represent one denomination
        int cols = amount; // Columns will have all the possible numbers till amount
        int[][] dp = new int[rows + 1][cols + 1]; // Initialize dp 'matrix' because there are 2 decision making variables, coins and the amount. We will also be using a '0' dummy row and column to make sure the values for the first actual row are not manually calculated

        dp [0][0] = 0; // 0 amount can be made using 0 number of '0' coins

        for(int i = 1; i <= cols; i++) //Fill in values for the dummy row
            dp[0][i] = 99999; // For the first row, we will be choosing the minimum between the value above (when the coin is not chosen) and the value coins[i] steps back plus the current chosen coin. If the row above is dummy, we should make sure the second option is chosen, therefore it is set to a very large number

        for(int i = 1; i <= rows; i++){ // Loop through every cell in the dp matrix excluding the dummy row and column
            for(int j = 0; j <= cols; j++){
                if(j < coins[i - 1]) // We only have the zero case (amount above) of not choosing the coin until the amount becomes equal to the denomination because if we choose the coin, we will end up with a negative number
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i - 1]] + 1); // Choose the minimum between not choosing the coin (0 case) and choosing the coin (1 case). If we choose the coin, we have the subproblem value to the left plus one because we are choosing the coin
            }
        }
        if(dp[rows][cols] == 99999) // The amount cannot be made with the given coins
            return -1;
        return dp[rows][cols]; // Minimum number of coinss
    }
}