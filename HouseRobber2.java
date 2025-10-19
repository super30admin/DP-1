/**
 * This uses bottom-up approach. This has o(n) time complexity where n is the length of nums.
 */
public class HouseRobber2 {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n -1];
    }


    public static void main(String[] args) {
        int rob = new HouseRobber2().rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);

        rob = new HouseRobber2().rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}
