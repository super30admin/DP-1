// Time Complexity : O(amount * n) where n is the number of coin denominations
// Space Complexity : O(amount) as we use amount + 1 as the length of dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Create a dp array to store the fewest number of coins needed to make up each amount from 0 to the given amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize the dp array with a value greater than the maximum possible amount

        dp[0] = 0; // Base case: 0 coins are needed to make up 0 amount

        // Iterate through each coin denomination
        for (int coin : coins) {
            // Iterate through each amount from the coin value to the given amount
            for (int i = coin; i <= amount; i++) {
                // Update the dp array by choosing the minimum between the current value and the value obtained by using the current coin denomination
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If the value in dp[amount] is still greater than the given amount, it means it's not possible to make up the amount using the given coins
        // Return -1 in such cases, otherwise return the value in dp[amount]

        if(dp[amount] > amount)
        {
            return -1;
        }

        else
        {
            return dp[amount];
        }
    }
}
