class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
         dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i< nums.length; i++) {

            int case0 = dp[i-1];
            int case1 = nums[i] + dp[i-2];
            dp[i]=Math.max(case0, case1);
        }
        return dp[nums.length-1];
    }
}