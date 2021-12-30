// Time Complexity : number.length (linear)
// Space Complexity : constant
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n
class Solution {
    public int rob(int[] nums) {
        
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        
        int max;
        for(int i=1; i<nums.length; i++) {
            max = Math.max(dp[1], dp[0]+nums[i]);
            dp[0] = dp[1];
            dp[1] = max;
        }
        return dp[1];
    }
}