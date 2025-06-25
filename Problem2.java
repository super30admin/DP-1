// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem2 {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length + 2];
       for(int i = 2; i < dp.length; i++){
           dp[i] = Math.max(dp[i-1], nums[i-2] + dp[i-2]);
       }
       return dp[dp.length -1];
    }
}
