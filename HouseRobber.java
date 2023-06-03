public class HouseRobber {
    // Recursive approach
    // public int rob(int[] nums) {
    // return helper(nums, 0, 0);
    // }

    // private int helper(int[] nums, int idx, int amount) {
    // // base
    // if (idx >= nums.length)
    // return amount;
    // // logic
    // int case1 = helper(nums, idx + 2, amount + nums[idx]);
    // int case2 = helper(nums, idx + 1, amount);
    // return Integer.max(case1, case2);
    // }

    // Using DP-Tabulation
    // public int rob(int[] nums) {
    // if (nums.length == 1)
    // return nums[0];
    // int dp[] = new int[nums.length];
    // dp[0] = nums[0];
    // dp[1] = Integer.max(nums[0], nums[1]);
    // for (int i = 2; i < dp.length; i++) {
    // dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
    // }
    // return dp[nums.length - 1];
    // }

    // With Space Optimization
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int prev = nums[0];
        int curr = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = curr;
            curr = Integer.max(curr, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
