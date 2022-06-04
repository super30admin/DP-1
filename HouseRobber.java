// Time Complexity : O(n) where n is the size of nums
// Space Complexity : O(n) where n is the size of nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i =2; i<dp.length;i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
            
        return dp[nums.length-1];
    }
}