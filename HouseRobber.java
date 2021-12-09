// Time Complexity : O(n), ignoring constant
// Space Complexity : O(n), ignoring constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        // construct a 2-D array with skip case and take case as columns
        int[][] dp = new int[nums.length][2];
        // construct take column as nums[0]
        dp[0][1] = nums[0];

        // traverse along the nums array to compute
        // skip case and take case for every element in array
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }

        // at the end compare skiping and taking last element to
        // get the maximum amount and return
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}