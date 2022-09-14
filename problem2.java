// Problem1 - https://leetcode.com/problems/house-robber/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem2 {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
        }
        return dp[n-1];
}
