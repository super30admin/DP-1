// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// set zero position as max value of both the value above it, set one position as zero position of above + current num
// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums){
        if( nums == null || nums.length == 0) return 0;
        int [][] dp = new int [nums.length][2];
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}