// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        int[][] dp = new int[nums.length + 1][2];
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int i = 1; i <= nums.length; i++) {
            
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i-1] + dp[i-1][0];
        }
        
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}