// Time Complexity : O(n * m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


public class Solution {
    public int coinChange(int[] coins, int amount) {
      int maxSum = amount + 1;
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, maxSum);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
      }
      return dp[amount] > amount ? -1 : dp[amount];
    }
  }