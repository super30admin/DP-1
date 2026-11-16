// Time Complexity: O(n), where n is the number of houses.
// Space Complexity: O(n), for the 1D DP array.
// Approach: Bottom-Up Dynamic Programming (House Robber).
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length<2) return nums[0];
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
