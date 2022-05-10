public class CoinChange {
  // Time Complexity : O(mxn)
  // Space Complexity : O(mxn)
  // Did this code successfully run on Leetcode : Yes
  public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    for (int i = 0; i < dp.length; i++)
      dp[i][0] = 0;
    for (int i = 0; i < dp[0].length; i++)
      dp[0][i] = amount + 1;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (j < coins[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
        }
      }
    }
    int res = dp[dp.length - 1][dp[0].length - 1];
    if (res > amount)
      return -1;
    return res;
  }

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = { 1, 2, 5 };
    System.out.println(cc.coinChange(denominations, 11));
  }
}