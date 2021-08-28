// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 recursive formula: dp[i] = Math.max(cur + dp[i - 1] , dp[i - 2]);
 Because at every house, we need to decide whether to include the house in the final
 output or not.
 **/

class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i =0; i < nums.length; i++) {
            int temp = prev1;
            prev1 = Math.max(nums[i] + prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}