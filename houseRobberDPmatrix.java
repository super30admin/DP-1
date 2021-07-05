// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        //base case to check if the array is empty
        if(nums == null || nums.length == 0)
            return 0;
        
        //if only one house then rob that!
        if(nums.length == 1)
            return nums[0];
        
        //choose or don't choose matrix
        int[][] dp = new int[nums.length][2];
        
        //the first don't choose part is 0
        dp[0][1] = nums[0];
        
        //loop through all the houses
        for(int i = 1; i < nums.length; i++){
            
            //don't choose is the max out of the previous two values
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //choose is the previous skip with the new house added
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        
        //max of the last two values is the solution
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}