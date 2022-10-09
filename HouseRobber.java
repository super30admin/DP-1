// Exhaustive Search O(n!)
class HouseRobber {
    public int rob(int[] nums) {
	/*
         * O(n!) - Time Complexity
         */
        // base case
        if (nums.length == 0 || nums == null) return 0;
        // recursive / exhaustive approach
        return helper(nums, 0, 0);
    }

    public int helper(int[] arr, int index, int amount) {
        // base case
        if (index >= arr.length) {
            return amount;
        }
        // choose
        int case1 = helper(arr, index+2, amount + arr[index]);
        // not to choose
        int case2 = helper(arr, index+1, amount);

        return Math.max(case1, case2);
    }

    // DP Solution
    public int robDP(int[] nums) {
        /*
         * O(n) - Time & Space Complexity
         */
        // base case
        if (nums.length == 0 || nums == null) return 0;

        // dp
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][1] = nums[0]; // dp[0][0] is default 0;

        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
