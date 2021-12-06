
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach 1:
// Time Complexity : O(n)
// Space Complexity : O(n)
// We see that we have the option to choose a particular house or not
// So we can employ Recursion on this
// In recursion we see that there overlapping subproblems 
// So we use dp

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);

    }

}

// Approach 2:

// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return solve(nums, 0, 0);
    }

    public int solve(int[] nums, int i, int amount) {

        // base
        if (i >= nums.length)
            return amount;

        // logic

        int case1 = solve(nums, i + 1, amount);
        int case2 = solve(nums, i + 2, amount + nums[i]);

        return Math.max(case1, case2);
    }
}