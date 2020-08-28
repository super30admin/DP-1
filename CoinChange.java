// Time Complexity : O(A * C) where A = Amount and C = no of coins
// Space Complexity : O(A) where A = Amount 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1. We take a 2D matrix dp and cache the values of the subproblems.
//2. If we have already solved a particular subproblem then we store in that particular cell.
//3. If not we go ahead and compute it and store in the cell.
//4. We consider n x m matrix where m is the no of coins and n is the amount.
//5. The amount made up with coin 0 would be 0 so we fill the first column with 0.
//6. Similarly the amount made up with coin 0 would be 0 so we store infinity here.
//7. Then we traverse in the matrix and if the amount is less that coin value then we simply add the previous sub problem value in the cell.
//8. If not then we compare the it with the already computed value and the (amount-coin) value add 1 to it as we are selecting that.
//9. Then we return the last element in the matrix if it is less than the Integer.MAX_VALUE or else we return -1. 



class CoinChange {
  public int coinChange(int[] coins, int amount) {

    // int[] dp = new int[amount + 1];
    // Arrays.fill(dp, amount + 1);
    // dp[0] = 0;

    // for (int i = 0; i <= amount; i++) {
    // for (int j = 0; j < coins.length; j++) {
    // if (coins[j] <= i) {
    // dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
    // }
    // }
    // }
    // return dp[amount] > amount ? -1 : dp[amount];

    int dp[][] = new int[coins.length + 1][amount + 1];

    for (int i = 0; i <= coins.length; i++)
      dp[i][0] = 0;
    for (int j = 0; j <= amount; j++)
      dp[0][j] = 99999;

    for (int i = 1; i <= coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j < coins[i - 1])
          dp[i][j] = dp[i - 1][j];
        else
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
      }
    }

    return dp[coins.length][amount] >= 99999 ? -1 : dp[coins.length][amount];

  }

  public static void main(String args[]) {
    CoinChange ch = new CoinChange();

    int[] coins = { 1, 2, 5 };
    int amount = 11;
    System.out.println("Minimum no of coins needed = " + ch.coinChange(coins, amount));

  }
}