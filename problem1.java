// Time Complexity : O(n * amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just needed to initialize dp array properly with max values.


// Your code here along with comments explaining your approach in three sentences only
// I use dynamic programming where dp[i] stores the minimum coins needed to make amount i.
// For each amount, I try every coin and update dp if using that coin gives a better result.
// In the end, if dp[amount] is still large, return -1 otherwise return dp[amount].

import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
