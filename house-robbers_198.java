// Time Complexity : O(n) where  n = number of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// find the recurrence relation or what we call as subproblem
// in this case if we know the optimal solution for smaller amout then we can calculate for larger
//dp[i] = min {dp[i-1], dp[i-2]+nums[i] }
//Either we steal the current house, in that case leave the previous house ie i-1 values
//or we steal the house [i-2], then we add current house value + total optimal value for house[i-2]
// base case:
// dp[0] = nums[0]
// dp[1] = Math.max(nums[0], nums[1])

class Solution {
    public int rob(int[] nums) {

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if(nums.length == 1) {
            return nums[0];
        }
        int[]  dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }
}
