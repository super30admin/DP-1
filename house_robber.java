// Time Complexity : O(n); n = nums.length
// Space Complexity : 0(n); dp 1-D array
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        // If only one house to rob, rob it's money
        if(nums.length == 1) {
            return nums[0];
        }

        int max = Math.max(nums[0], nums[1]);
        // If only two houses to rob, rob the house that has maximum money
        if(nums.length == 2) {
            return max;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = max;

        for(int i = 2; i < nums.length; i++) {
            // Make 2 decisions:
            // 1. Either rob the house you are at, which means
            // money you make is money of this house + maximum money you could make 1 house before, i.e. nums[i] + dp[i - 2]
            // 2. Or do not rob this house, and continue making the maximum money you could make
            // just before this current house you are at, i.e. dp[i-1]
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length - 1];
    }
}