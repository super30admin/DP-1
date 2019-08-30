// Solution 1 - Recursive

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n); Recursion Stack
 */

class Solution {
  public int coinChange(int[] coins, int amount) {
      return bruteforce(amount,coins);
  }
  public int bruteforce(int amount, int[] coins){
      if(amount < 0)
          return -1;
      if(amount == 0)
          return 0;
      
      int min = -1;
      
      for(int i = 0; i < coins.length; i++){
          int val = bruteforce(amount-coins[i],coins);
          if(min != -1 && val != -1)
              min = Math.min(min,val + 1);
          else if(min == -1&& val != -1)
              min = val+1;
      }
      
      return min;
      
  }
}

// Solution 2 - DP

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
  public int coinChange(int[] coins, int amount) {

    if(amount < 1) return 0;

    int[] dp = new int[amount + 1];

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i<= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[j], dp[i-coins[j]] + 1);
        }
      }
    }
    return (dp[amount] > amount ? -1 : dp[amount]);
      
  }
}