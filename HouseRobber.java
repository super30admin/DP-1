// Solution 1 - Recursive

/**
 * Time Complexity: O(2^n); Since each call is calling itself two times and it'll be n times that we'll touch the return case.
 * Space Complexity: O(n); Recursion Stack
 */

class Solution {
  public int rob(int[] nums) {
      return helper(nums, 0, false, 0);
  }

  private int helper(int[] nums, int i, boolean prevHouse, int curSum) {
    
    if (i == nums.length)
      return curSum;
    
    // Base Case
    int case1 = 0;
    int case2 = 0;

    if (!prevHouse) {     // Previous house has not been robbed
      case1 = helper(nums, i+1, true, curSum+nums[i]);
    }
    case2 = helper(nums, i+1, false, curSum);

    return Math.max(case1, case2);
  }
}


// Solution 2 - DP

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n); The array made to store previous result
 */

class Solution {
  public int rob(int[] nums) {
    int[] dp = new int[nums.lenght + 2];

    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-2]);
    }

    return dp[dp.length - 1];
  }
}