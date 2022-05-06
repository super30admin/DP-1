// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[401];
        dp[0] = 0;
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            dp[i]=Math.max(nums[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length];

    }
}