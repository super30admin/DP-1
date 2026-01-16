// Time Complexity : O(N) Each House is Visited
// Space Complexity :O(Dp Array) We make extra array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        // If no houses
        if (nums.length == 0) return 0;
        // If only one house
        if (nums.length == 1) return nums[0];
        // dp[i] = max money we can rob till house i
        int[] dp = new int[nums.length];
        // Base case
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        // Fill dp arr
        for (int i=2;i<nums.length;i++) {
            dp[i]= Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        // Answer is last value
        return dp[nums.length - 1];
    }
}
