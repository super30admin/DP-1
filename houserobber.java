/**
Time complexity : O(n) n= no of elements in array
Space complexity : O(n) n = new dp array of n elements
Did it run on Leetcode : Yes
 */

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] =0;
        dp[0][1] = nums[0];
        for(int i=1; i<nums.length; i++){
            // case-1: not going with the present house
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //case-2 : going with present house
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}