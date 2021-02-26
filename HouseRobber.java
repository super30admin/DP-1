// Time Complexity : O(n)
// Space Complexity : O(n)

public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            } else {
                dp[i] = nums[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 1 };
        int maxProfit = rob(nums1);
        System.out.println(maxProfit);

        int[] nums2 = { 2, 7, 9, 3, 1 };
        maxProfit = rob(nums2);
        System.out.println(maxProfit);
    }
}