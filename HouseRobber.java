//Time Complexity : O(nums.length)
//Space Complexity : O(nums.length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes



class Solution {
    public int rob(int[] nums) {
       if(nums == null || nums.length == 0) return 0;
       int[] dp = new int[2 * nums.length];
       dp[1] = nums[0];
       int index = 1;
       for(int i = 2; i < 2 * nums.length; i = i + 2) {
           dp[i] = Math.max(dp[i - 1], dp[i - 2]);
           dp[i + 1] = dp[i - 2] + nums[index++];
       }
        return Math.max(dp[2 * nums.length - 1], dp[2 * nums.length - 2]);
    }
}
