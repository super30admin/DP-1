public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        int non_adj_sum = 0;
        dp[1] = nums[0];
        for(int i=1; i<nums.length;i++){
            dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.length];
    }
}
