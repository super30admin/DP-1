// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n) where n is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2]; // n cuz we are including the 0th condition as well
        // dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            // not choose
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            // choose
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(hr.rob(nums)); // Output: 12
    }
}
