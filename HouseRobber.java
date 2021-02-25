// Time Complexity : O(n); n = len of array
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class HouseRobber {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int rows = nums.length;
        int cols = 2;
        int[][] dp = new int[rows][cols];

        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < rows; i++) {
            dp[i][0] = nums[i] + dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(dp[rows - 1][0], dp[rows - 1][1]);
    }
    // Method - 2 - optimized space complexity
    // Time Complexity : O(n); n = len of array
    // Space Complexity : O(1)
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int c = nums[0];
        int temp = 0;
        int dc = 0;

        for (int i = 1; i < nums.length; i++) {
            temp = dc;
            dc = Math.max(temp, c);
            c = temp + nums[i];
        }

        return Math.max(c, dc);
    }
}