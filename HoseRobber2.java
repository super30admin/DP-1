public class HoseRobber2 {
    public int robber(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        dp[0][1] = 0;
        dp[1][0] = 0;
        int max = Integer.MIN_VALUE;

        for (int row = 1; row <= nums.length; row++) {
            int notTaken = Math.max(dp[row - 1][0], dp[row - 1][1]);
            int taken = dp[row - 1][0] + nums[row - 1];
            max = Math.max(max, Math.max(notTaken, taken));

            dp[row][0] = notTaken;
            dp[row][1] = taken;
        }

        return max;

    }
}
