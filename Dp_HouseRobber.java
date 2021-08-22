// Time Complexity : O(n) , n=length of array nums
// Space Complexity : O(n), n=length of array nums
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1)
            dp[0] = nums[0];
        if(nums.length==2)
            dp[1] = Math.max(nums[0],nums[1]);
        if(nums.length>2) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for(int i=2;i<nums.length;i++)
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[dp.length-1];
    }
}