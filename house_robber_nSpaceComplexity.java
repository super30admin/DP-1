// always dp[i][0] shall be the max of 0 and 1 column and dp[i][1] shall be dp[i - 1][0] + nums[i]
//this approachmakes use of o(n) space complexity
// Time Complexity : o(n)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}