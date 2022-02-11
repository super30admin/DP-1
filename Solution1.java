/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1, dp);
    }
    
    public int rob(int[] nums, int i, int[] dp){
        if(i < 0){
            return 0;
        }
        
        if(dp[i] >= 0){
            return dp[i];
        }
        
        int ans = Math.max(rob(nums, i-2, dp) + nums[i], rob(nums, i - 1, dp));
        dp[i] = ans;
        return dp[i];
    }
}
