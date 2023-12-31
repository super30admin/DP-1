//TC = O(n)
//SC = O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp [1] = Math.max(0 + nums[1], dp[0]);
        for(int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
        }

        return dp[n-1];
    }
}