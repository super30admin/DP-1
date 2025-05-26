// TC: O(m*n)
// SC: O(m*n)
// Approach : Using dp matrix 

public class Coin_Change_Tabulation {

  public int coinChange(int[] coins, int amount) {
    int m = amount;
    int n = coins.length;
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 0;

    for (int j = 1; j <= m; j++) {
      dp[0][j] = Integer.MAX_VALUE - 10;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        // till amount is less than denomination of coin
        if (j < coins[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
        }
      }
    }
    if (dp[n][m] >= Integer.MAX_VALUE - 10)
      return -1;
    return dp[n][m];
  }

  public static void main(String[] args) {
    Coin_Change_Tabulation cc = new Coin_Change_Tabulation();
    int[] coins = new int[] { 1, 2, 5 };
    int amount = 11;

    System.out.println(cc.coinChange(coins, amount));
  }
}