import java.util.Arrays;

// Time Complexity : O(N) (as we are iterating over each possible optimal solution)
// Space Complexity : O(N) (as we are using dp table)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution2 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];

        // initializing dp
        dp[nums.length] = 0; // dummy house
        dp[nums.length - 1] = nums[nums.length - 1]; // last house

        // Construct dp table, from last to first
        for (int i = nums.length - 2; i >= 0; --i) {

            // Current amount robbed will be checking max from previous 2 houses
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }

        // max amount will be in first element of dp table
        return dp[0];
    }
}
