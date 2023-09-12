class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Check for edge cases where coins array is empty or null
        if (coins == null || coins.length == 0)
            return -1;
        
        // Create a 2D array dp to store the minimum number of coins needed for different subproblems
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Initialize the first row of dp with a value greater than 'amount' to indicate it's not possible to make change
        for (int j = 0; j < amount + 1; j++)
            dp[0][j] = amount + 1;

        // Iterate through each coin denomination and amount to populate the dp array
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                // If the current coin value is greater than the current amount 'j', copy the value from the row above
                if (j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                    
                // Otherwise, take the minimum of either using the current coin or not using it
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        
        // If the final entry in dp is still greater than 'amount', it means it's not possible to make change
        if (dp[coins.length][amount] == amount + 1)
            return -1;
        
        // Return the minimum number of coins needed to make the desired amount
        return dp[coins.length][amount];
    }
}

// Time Complexity: O(m * n) where m is the number of coin denominations and n is the target amount
// Space Complexity: O(m * n) for the dp array, which stores the minimum coin counts for different subproblems
