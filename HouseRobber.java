// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;

        for(int r = 1; r < dp.length;r++){
            dp[r][0] = Math.max(dp[r-1][0] , dp[r-1][1]);
            dp[r][1] = dp[r-1][0] + nums[r-1];
        }

        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);


    }
}