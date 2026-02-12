// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample {
    // Time Complexity : O(m * n) where m is amount and n is number of coins
    // Space Complexity : O(amount)
    // Did this code successfully run on Leetcode : Yes
    // Use DP to solve this problem, create dp array to store minimum number of coins needed for amount
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j - coins[i]] + 1 < dp[j] ? dp[j - coins[i]] + 1 : dp[j];
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];

    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : yes
    public int rob(int[] nums) {
        int max = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j - 2 == 0) { // this when we have reached the first second house we can rob
                nums[j] = nums[j - 2] + nums[j];// make changes in the array
            } else if (j - 2 > 0) { // compare the 2 houses before and choose the maximum
                nums[j] = nums[j - 2] > nums[j - 3] ? nums[j - 2] + nums[j] : nums[j - 3] + nums[j];
            }
            max = Math.max(nums[j], max);
        }
        return max;
    }
}
