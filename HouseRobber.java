// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[][] dp = new int[nums.length +1][2];
        
        for(int j = 0; j < 2; j++)
        {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < dp.length; i++)
        {
            //choose case
            dp[i][0] = dp[i - 1][1] + nums[i - 1];
            
            //don't choose case
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}