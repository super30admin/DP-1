// Time Complexity : o(m x n)
// Space Complexity :o(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int [][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i =1; i<nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
        
    }
}