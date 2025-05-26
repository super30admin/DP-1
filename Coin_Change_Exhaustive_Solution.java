// TC: O(2^m+n) 
// SC: O(m*n)
// Approach : Using resursive function

public class Coin_Change_Exhaustive_Solution {

  public int coinChange(int[] coins, int amount) {
    int result = helper(coins, 0, amount);
    if (result >= Integer.MAX_VALUE - 10)
      return -1;
    return result;
  }

  private int helper(int[] coins, int idx, int amount) {
    // base
    if (amount == 0)
      return 0;
    if (amount < 0 || idx == coins.length)
      return Integer.MAX_VALUE - 10;

    // logic
    // dont choose
    int case1 = helper(coins, idx + 1, amount);

    // choose
    int case2 = 1 + helper(coins, idx, amount - coins[idx]);
    return Math.min(case1, case2);
  }

  public static void main(String[] args) {
    Coin_Change_Exhaustive_Solution cc = new Coin_Change_Exhaustive_Solution();
    int[] coins = new int[] { 1, 2, 5 };
    int amount = 11;

    System.out.println(cc.coinChange(coins, amount));
  }
}
