/**
Problem: https://leetcode.com/problems/house-robber/
TC: O(n)
SC: O(n)
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return nums[0];
        }
        
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i < nums.length; ++i) {
            if(i > 2) {
                dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            } else {
                dp[i] = dp[i-2] + nums[i];
            }
        }

        return Math.max(dp[n-1], dp[n-2]);
    }
}