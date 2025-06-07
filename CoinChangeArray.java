// Time Complexity : O(m * n), where m = number of coins, n = amount
// Space Complexity : O(n) , since we use a 1D array of size (amount + 1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This solution optimizes space using a 1D DP array where dp[j] stores the minimum number of coins needed for amount j.
// Initially, dp[0] = 0 and the rest are set to a high value (e.g., 99999) to signify infinity.
// For each coin, we try to update dp[j] for all j >= coin value by choosing the minimum between the current value
// and 1 + dp[j - coin] (representing including the current coin).
// If dp[amount] remains 99999, the amount cannot be formed, so return -1; otherwise, return dp[amount].

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        //DP table
        int[] dp = new int[n+1];

        //Populate 0th row to max
        for (int j = 1; j <= n; j++) {
            dp[j] = 99999;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //If denomination of the coin is greater than the amount->invalid so just take up
                if(coins[i-1] > j){
                    //no choose case
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }
            }
        }
        if(dp[n] == 99999) return -1;
        return dp[n];
    }
}