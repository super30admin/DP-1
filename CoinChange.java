// Approach: DP with optimized space
// Time complexity: O(N * M); N = coins.length + 1 and M = amount + 1
// Space complexity: O(M) for dp array.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Fill coins 0 and amount > 0 cases with max number of coins
        for (int j = 1; j <= amount; j ++) {
            dp[j] = amount + 1;
        }
        for (int i = 1; i <= coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                // Consider valid cases where denomination is greater than or equal to amount
                if (coins[i - 1] <= j) {
                    // Min between previously calculated coins and (amount - denomination) case + 1 coin
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }
        if (dp[amount] >= amount + 1) {
            // infinity/invalid case
            return -1;
        }
        return dp[amount];
    }
}