/**
 * TC : O(n) SC: O(n)
 * Approach : At every house decide which is max from these two options
 *             a) if rob this house and total from the last 2nd 
 *             b) rob the previous and leave this one out
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);;
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}