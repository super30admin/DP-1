//Time Complexity - O(n)
//Space Complexity - O(n)
//Did it run on Leetcode - Yes
//Approach - Initialize the first two rows of the matrix based on the input given. Fill the rest of the 1-D array.

class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;

        // Input Array is null or has no values
        if (n == 0 || nums == null) {
            return 0;
        }

        // Input has less than two values
        if (n < 2) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the 1-D array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

}
