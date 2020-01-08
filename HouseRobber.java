//Iterative Approach


// Time Complexity : o(2^n) - n number of houses
// Space Complexity :
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums== null || nums.length == 0)
            return 0;
        int dp[][] = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}






//DP Approach


// Time Complexity : O(n) n is the number of houses
// Space Complexity : O(n) n is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        if(nums== null || nums.length == 0)
            return 0;
        int dp[][] = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
    
