
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Using Tabulation store the max value in 1D dp array
Max is calculated by either skipping the current house to rob ie rob prev house
or robbing the current house and house 2 steps prev to current
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        //base cases
        dp[0] = 0;
        dp[1] = nums[0];
        //logic
        for(int i=2;i<=n;i++) {
            //take or skip
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}
