/**
 * Approach:
 * - Use bottom-up Dynamic Programming to find the minimum number of coins needed to make up the target amount.
 * - Create a DP array `a[]` of size `amount + 1`, where `a[i]` represents the minimum coins needed for amount `i`.
 * - Initialize all values as `Integer.MAX_VALUE` (unreachable), except `a[0] = 0` (base case).
 * - For each amount from 1 to target:
 *   - For each coin, if the coin can contribute to current amount and sub-result is valid,
 *     update `a[i] = min(a[i], 1 + a[i - coin])`.
 * - After filling the DP array:
 *   - If `a[amount]` is still `Integer.MAX_VALUE`, return -1 (no solution).
 *   - Otherwise, return `a[amount]` as the minimum number of coins.
 */

// Time Complexity : O(amount * N)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] a = new int[amount + 1];
        a[0] = 0; // Base case: 0 coins needed for amount 0
        for (int i = 1; i <= amount; i++) {
            a[i] = Integer.MAX_VALUE;
            // Try every coin for current amount
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && a[i - coins[j]] != Integer.MAX_VALUE) {
                    a[i] = Math.min(a[i], 1 + a[i - coins[j]]);
                }
            }
        }
        // If amount is unreachable, return -1
        return a[amount] == Integer.MAX_VALUE ? -1 : a[amount];
    }
}
