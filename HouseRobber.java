// Time Complexity : O(n)
// Space Complexity : O(n) for matrix approach & O(1) for attribute approach
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    /** With  Matrix
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length -1][0], dp[nums.length -1][1]);
    }
    **/

    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int pick = 0;
        int leave = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int tmpPick = pick;
            pick = Math.max(pick, leave);
            leave = tmpPick + nums[i];

        }
        return Math.max(pick, leave);
    }
}
