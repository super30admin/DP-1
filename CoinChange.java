class CoinChange {

  /**
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * 
   * Any Problems solving this? No
   * Were you able to solve it on leetcode? Yes
   * 
   */
  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount];

    return coinChangeHelper(coins, amount, memo);
  }

  int coinChangeHelper(int[] coins, int amount, int[] memo) {
      if(amount == 0) { return 0; }
      if(amount < 0) { return -1; }
      
      if(memo[amount-1] != 0) { return memo[amount-1]; }
      
      int min = Integer.MAX_VALUE;
      
      for(int coin : coins){
          int reqCoins = coinChangeHelper(coins, amount - coin, memo) + 1;
          if(reqCoins > 0 && reqCoins < min){
              min = reqCoins;
          }
          
          memo[amount-1] = (min == Integer.MAX_VALUE) ? -1 : min;
      }
      
      return memo[amount-1];
  }
}
