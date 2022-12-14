// House Robber
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// As the only variable is house, so will consider a 1-d array.
// Then choose maximum number bewteen (current + 2 steps back number) & just the previous index number

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int n = nums.length;
        int [] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i= 2; i < n; i++) {
            //if we'r choosing current num.  //if not previous num
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}