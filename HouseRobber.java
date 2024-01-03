

class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // int result = helper(nums, 0, 0);

        int n = nums.length;
        int[] dp  = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], 0 + nums[1]);

        for(int i = 2; i < n; i++ ) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];

        // return result;
    }

    private int helper(int[] nums, int idx , int amount) {
        // base

        if(idx >= nums.length) return amount;

        //chose
        int case1 = helper(nums, idx + 2, amount + nums[idx]);

        //not chose
        int case2 = helper(nums, idx + 1, amount);

        return Math.max(case1, case2);
    }
}
