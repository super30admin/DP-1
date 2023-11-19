// Time Complexity: O(n)
// Space Complexity: O(n)
class HouseRobber {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];

        if(dp.length < 2) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}