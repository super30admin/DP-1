// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : None.

class houseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        if(len >= 2) {
            for(int i = 2; i < len; i++){
                dp[i] =  Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        return dp[len - 1];

    }
}