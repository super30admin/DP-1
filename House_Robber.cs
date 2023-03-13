public class Solution {
    public int Rob(int[] nums) {
        if (nums.Length < 2) {
            return nums[0];
        } else {
            int[] dp = new int[nums.Length];
            dp[0] = nums[0];
            dp[1] = Math.Max(nums[0], nums[1]);
            for (int i = 2; i < nums.Length; i++) {
                dp[i] = Math.Max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.Length - 1];
        }
    }
    
}