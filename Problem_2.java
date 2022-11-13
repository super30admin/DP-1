// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//198. House Robber
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}