//TC is o(n) and SC is o(n)
class Solution {

    private int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int maxMoney = recursion(nums, 0);
        return maxMoney;
    }

    private int recursion(int[] nums, int index) {
        // base
        // valid

        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] == -1) {
            // recurse
            // select
            int select = nums[index] + recursion(nums, index + 2);
            // notSelect
            int notSelect = recursion(nums, index + 1);

            dp[index] = Math.max(select, notSelect);
        }
        return dp[index];
    }
}