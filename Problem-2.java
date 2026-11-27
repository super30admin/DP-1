// Time Complexity: O(n) where n is number of elements in nums.
// Space Complexity: O(n) where n is number of elements in nums.

// Approach: Create a DP array of size nums.length+1, where dp[i] represents the maximum amount that can be robbed from the first i houses. Initialize dp[0] = 0 and dp[1] = nums[0].
// Iterate from i = 2 to nums.length and update dp[i] by taking the maximum of not robbing the current house (dp[i-1]) and robbing the current house (dp[i-2] + nums[i-1]).
// Return dp[nums.length].

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.
class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<nums.length+1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}
