// Time Complexity : O(n); where n is size of array of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public int rob(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int dp = nums[0];
        int dp1 = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int result = Math.max(nums[i] + dp, dp1);
            dp = dp1;
            dp1 = result;
        } return dp1;
    }
}