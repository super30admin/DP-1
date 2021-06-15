// Time Complexity : O(n), where n is lenght of nums
// Space Complexity : O(n), where n is size of dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}