// Time Complexity : O(n)
// Space Complexity : O(n)
// Method : DP

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length, pick, non_pick;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i = 1; i < n; i++)
        {
            pick = nums[i];

            if(i > 1) pick += dp[i - 2];

            non_pick = dp[i - 1];

            dp[i] = Math.max(pick, non_pick);
        }

        return dp[n - 1];
    }
}