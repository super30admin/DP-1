// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : (i) dp[i+2]+nums[i] -> In this part I was confused and had to take and example to understand that its nums[i] and not i-1 or i+1 (ii) I could't imagine the table on my own. Had to refer to the solution once for understanding the table.

//bottom-up approach of dp
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int[]dp = new int[nums.length+1];
      //initialization
        dp[dp.length-1] = 0;
        dp[dp.length-2] = nums[nums.length-1];
        
        for(int i=dp.length-3; i>=0; i--){
          //find the max of current+1 and current+2+value of the house
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        return dp[0];
    }
}
