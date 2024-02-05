// Time Complexity : O(n) 
// Space Complexity : O(n), can be optimized to O(1) by using two variables instead of array
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Go exhaustive and look for all the possible comibnations
// to find the max robbing amount possible. Optimize by storing the intermediate values in dp array. instead of array two
// variables can also be used.

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);

        for(int i = 2 ; i < nums.length ; i++){

            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }

        return dp[nums.length-1];
    }
}