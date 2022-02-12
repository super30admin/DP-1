// Time Complexity: O(n)
// Space Complexity: O(n)

// Approach: I create a dp array which stores the max value of the sum until now.

class HouseRobber {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int dp[] = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
    }

    return dp[nums.length];
  }
}