// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HouseRobber {
    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public int robRec(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int robbings) {
        //base
        if (index >= nums.length) {
            return robbings;
        }
        //choose
        int case1 = helper(nums, index + 2, robbings + nums[index]);
        //not choose
        int case2 = helper(nums, index + 1, robbings);
        return Math.max(case1, case2);
    }
}