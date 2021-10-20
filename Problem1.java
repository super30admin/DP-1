// Time -> o(n)
// Space -> O(n)
// Leetcode 198 - House robber
class Solution {
    public int rob(int[] nums) {
        
        return calculateMaxRob(nums);
    }
    
    private int calculateMaxRob(int[] nums){
        
         int [][] dp = new int[nums.length][2];
         dp[0][0] = 0;
         dp[0][1] = nums[0];
        
         for(int i=1;i<dp.length; i++){
             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
             dp[i][1] = nums[i] + dp[i-1][0];
         }
        
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}