
public class HouseRobber {

    // Steps:
    // At each house i, decide:
    // 1. Rob it → add → dp[i-2] + nums[i]
    // 2. Skip it → → dp[i-1]

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        int maxAmount = solution.rob(nums);
        System.out.println("Maximum money robbed: " + maxAmount); // Output: 12
    }
}
