// Time Complexity : O(m * n)
// Space Complexity :O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int m = coins.size();
        int n = amount;

        // Create a 2D vector 'dp' to store intermediate results
        // dp[i][j] represents the minimum number of coins needed to make change for amount 'j'
        // using the first 'i' coin denominations
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

        // Initialize the first row of 'dp' with a large value (999999)
        // This value serves as a placeholder for unattainable states
        for (int i = 0; i <= m; ++i) {
            fill(dp[i].begin(), dp[i].end(), 999999);
        }

        // Base case: no coins are needed to make change for amount 0
        dp[0][0] = 0;

        // Dynamic programming loop to fill the 'dp' table
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                // If the current amount 'j' is less than the coin denomination 'coins[i - 1]',
                // we can't use the current coin, so we inherit the value from the previous row
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Otherwise, choose the minimum between not using the current coin
                    // (inheriting the value from the previous row) and using the current coin
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        // Retrieve the result from the bottom-right corner of the 'dp' table
        int result = dp[m][n];

        // If the result is still the initial placeholder, return -1 (indicating no valid solution)
        if (result >= 999999) return -1;

        // Otherwise, return the minimum number of coins needed to make change for the given amount
        return result;
    }
};
