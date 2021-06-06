// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] nums) {
      //recursive approach
      //null case
      if(nums.length == 0 || nums == null) return 0;
      // int [][] dp = new int[nums.length][2];
      // dp[0][1] = nums[0]; 
      int skip = 0; int take = nums[0];
      for(int i =1; i< nums.length; i++) {
//         //not choose
//         dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//         //choose
//         dp[i][1] = dp[i-1][0] + nums[i];
        int prevSkip = skip;
        //not choose
        skip = Math.max(skip,take);
        //choose
        take = prevSkip + nums[i];
        
      }
        
      //return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
      return Math.max(skip,take);
    }
}