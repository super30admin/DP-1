// Time complexity : O(n)
// Space complexity : O(n)
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = { 6, 9, 8, 1, 1, 6 };
        int result = rob(nums);
        System.out.println("Maximum Robbing :: " + result);
    }

    /**
     * @param nums
     * @return maximum amount of money we can rob
     */
    private static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n < 2)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }
}
