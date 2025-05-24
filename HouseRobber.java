// Time Complexity O(n)
// Space Complexity O(n)
// Runs on LeetCode: Yes
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        if (nums.length == 1)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int choose = nums[i] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(choose, skip);
        }

        return dp[nums.length - 1];
    }
}
