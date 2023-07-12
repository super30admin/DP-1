// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
  public int rob(int[] nums) {
    int prev1 = 0;
    int prev2 = 0;

    for (final int num : nums) {
      final int dp = Math.max(prev1, prev2 + num);
      prev2 = prev1;
      prev1 = dp;
    }

    return prev1;
  }
}