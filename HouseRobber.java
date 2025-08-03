// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// We use DP where dp[i] represents the max money that can be robbed from the first i+1 houses.
// At each step, choose max of: (rob current + dp[i-2]) or (skip current and take dp[i-1]).

public class HouseRobber {
    public int rob(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
