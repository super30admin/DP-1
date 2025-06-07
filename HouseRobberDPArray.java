// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n) for the dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This is a bottom-up Dynamic Programming solution to the House Robber problem.
// The idea is to track the maximum money that can be robbed up to each house without robbing two adjacent houses.
// At each step, we decide whether to rob the current house (and add it to the value from two houses back)
// or skip it (and take the max value up to the previous house).
// We build a dp array where dp[i] represents the maximum money that can be robbed up to house i.

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // If only one house, rob it
        if (n == 1) return nums[0];

        // DP array to store max rob amounts
        int[] dp = new int[n];

        // Rob the first house
        dp[0] = nums[0];

        // Rob the house with the higher value between the first two
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the rest of the dp array
        for (int i = 2; i < n; i++) {
            // Choose the maximum between:
            // 1. Not robbing current house: dp[i-1]
            // 2. Robbing current house: nums[i] + dp[i-2]
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        // The last value contains the maximum amount that can be robbed
        return dp[n - 1];
    }
}