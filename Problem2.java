// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class Problem2 {
    public static int[] dp;

    public static int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, 0);
    }

    public static int rob(int[] nums, int index) {
        // base
        if (index >= nums.length) {
            return 0;
        }

        // recurse
        if (dp[index] == -1) {
            int select = nums[index] + rob(nums, index + 2);
            int notSelect = rob(nums, index + 1);
            dp[index] = Math.max(select, notSelect);
        }

        return dp[index];
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};
        System.out.print(rob(nums));
    }
}