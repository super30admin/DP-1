// Time Complexity: O(mn) where m is the number of coins and n is the value of amount
// Space Complexity: O(n) where n is the value of amount

// Approach: create a dp array of length amount+1. Fill it with amount+1 value.
// Every index of dp denotes the number of coins we'll need to get that index as amount.
// We check the min value of dp[i] or dp[i-coin] + 1 (1 is for the current coin). 

class CoinChange {
  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return -1;
    }

    if (amount == 0) {
      return 0;
    }

    int dp[] = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int coin : coins) {
      for (int i = coin; i < amount + 1; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    return dp[amount] <= amount ? dp[amount] : -1;
  }
}