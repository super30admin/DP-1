// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 198



class Solution {
    public int rob(int[] nums) {
        //edge
        if(nums == null || nums.length == 0 )
            return 0;
        
        int n = nums.length;
        int[][] dp = new int[n][2];
        //max at 1st index will be 1st element itself
        dp[0][1] = nums[0];
        for(int i = 1 ; i < n ; i++){
        
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
      return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
