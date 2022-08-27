// ## Problem2 (https://leetcode.com/problems/house-robber/)

class Solution {
    public int rob(int[] nums) {
        
        // time : O(n)
        // Space O(1)
        // null case
        if (nums==null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
}
}