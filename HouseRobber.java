// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        // Create a dp array to store the maximum amount of money that can be robbed up to each house
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Iterate through each house starting from the third house
        for (int i = 2; i < n; i++) {
            // Choose the maximum amount of money between robbing the current house + the amount from two houses before
            // or skipping the current house and taking the amount from the previous house
            System.out.println("nums[i]: " + nums[i]);
            System.out.println("dp[i - 2]: " + dp[i - 2]);
            System.out.println("dp[i - 1]: " + dp[i - 1]);
            System.out.println("Maximum: " + Math.max(nums[i] + dp[i - 2], dp[i - 1]));
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // The maximum amount of money that can be robbed is the last element in the dp array
        return dp[n - 1];
    }
}
