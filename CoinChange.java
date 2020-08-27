// Time Complexity : O(N2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
    We fill the array wit value amount +1. For each coin, we check the min of
    no. of coins so far and the value of this coin - coins[j] + 1.
    This way, the array element at index amount would give the min answer.

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount+1);
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