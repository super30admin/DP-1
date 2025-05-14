// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        int result = helper(coins, amount, dp);

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private int helper(int[] coins, int amount, Integer[] dp) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != null) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = helper(coins, amount - coins[i], dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        dp[amount] = min;
        return dp[amount];
    }
}
